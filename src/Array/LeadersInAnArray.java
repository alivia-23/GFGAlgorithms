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

    // Brute Force Approach
    public static List<Integer> findLeaders1(int[] nums) {
        List<Integer> leaders = new ArrayList<>();
        int n = nums.length;
        // outer loop iterates through all each element to compare with all the inner loop elements
        for (int i = 0; i < n; i++) {
            int j;
            // inner loop iterates from (i + 1) -> n for each element of outer loop
            for (j = i + 1; j < n; j++) {
                if (nums[i] <= nums[j]) {
                    break;
                }
            }
            // if j reaches end of the inner loop then current element contains max value from all the values of its left
            if (j == n) {
                leaders.add(nums[i]);
            }
        }
        return leaders;
    }

    // optimized approach
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
        System.out.println(findLeaders(nums));  // optimized result
        System.out.println(findLeaders(nums1)); // optimized result
        System.out.println(findLeaders1(nums1)); // brute force result
    }

}
