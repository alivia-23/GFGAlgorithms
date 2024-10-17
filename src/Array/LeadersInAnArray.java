package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Given an array arr[] of size n, the task is to print all the Leaders in the array. An element is a Leader if it is greater than all the elements to its right side.
 * Note: The rightmost element is always a leader.
 * Examples:
 * Input: arr[] = {16, 17, 4, 3, 5, 2}
 * Output: 17 5 2
 *
 * Input: arr[] = {1, 2, 3, 4, 5, 2}
 * Output: 5 2
 */
public class LeadersInAnArray {
    public static List<Integer> findLeaders(int[] nums) {
        List<Integer> leaders = new ArrayList<>();

        // start with the rightmost element
        int maxVal = nums[nums.length - 1];

        // rightmost element is always a leader
        leaders.add(maxVal);

        // traverse the array from right to left
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                leaders.add(maxVal);
            }
        }
        // reverse the array to maintain the order
        Collections.reverse(leaders);

        return leaders;
    }

    public static void main(String[] args) {
        int[] nums = {16, 17, 4, 3, 5, 2};
        int[] nums1 = {1, 2, 3, 4, 5, 2};
        System.out.println(findLeaders(nums));
        System.out.println(findLeaders(nums1));
    }

}
