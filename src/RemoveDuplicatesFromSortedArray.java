import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Example 2:
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 */
public class RemoveDuplicatesFromSortedArray {
    /**
     * Making use of extra space
     * Not so efficient
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public static int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                nums[i] = nums[i];
                set.add(nums[i]);
            }
        }
        return set.size();
    }

    /**
     * Without using extra space
     * Efficient approach is in-place arranging unique numbers in the nums array
     * Time Complexity - O(N)
     * Space complexity - O(1)
     *
     * Thought process-
     * Since the array is already sorted I'll start from the second index
     * I'll have 2 pointers, 1 keep tracks of the position of unique numbers and the other is the running pointers
     * whenever I get a unique number I'll update the left index with the unique number and increment left
     */

    public static int removeDuplicates1(int[] nums) {
        int left = 1;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left - 1] != nums[right]) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left; // return left because wherever my left pointer stops that is the end of the unique numbers
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int[] nums1 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicates(nums1));
        System.out.println(removeDuplicates1(nums));
        System.out.println(removeDuplicates1(nums1));
    }
}
