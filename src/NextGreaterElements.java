import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2.
 * If there is no next greater element, then the answer for this query is -1.
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4]
 * Output: [3,-1]
 *
 *
 * Approach :
 * Simple explanation is try to get the next greater elements of all the elements in nums1 which are present in nums2 and get the next greater elements from nums2
 *
 * Map -> For every elements in nums1 as key if the same element is present in nums2 then keep the index of that element as value
 * loop through the elements at nums1 and get the corresponding index at nums2 and start looping from that index till the length of nums2
 * then compare the current element with next element and add in the result
 * if it reaches end of nums2 then return -1 for that elelment
 *
 * Questions ?
 * 1) How to handle duplicates if any? -> the current problem consists of all unique elements in both the array
 *
 */
public class NextGreaterElements {
    // Better Brute Force approach
    // Time complexity - O(m*n) m -> number of elements in nums1 || n -> number of elements in nums2
    // In the worst case whole elements in nums2 be scanned for each element in nums1
    // Space Complexity -> O(n) n -> n represents the number of elements of nums2 which we store in the hashmap
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int index = map.get(nums1[i]);  // got the index of the element in nums1 which is also present in nums2
            int j;
            for (j = index + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
            if (j == nums2.length){
                result[i] = -1;
            }
        }
        return result;
    }

    private static void printArray(int[] result) {
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        printArray(nextGreaterElement(nums1, nums2));
    }

}