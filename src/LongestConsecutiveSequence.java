import java.util.*;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 */
public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        Arrays.sort(nums);

        int n = nums.length;
        int maxLength = 0;
        int curLength = 1;

        for (int end = 1; end < n; end++) {
            //when cur element equals prev elem + 1 => increment length
            if (nums[end - 1] + 1 == nums[end]) {
                curLength++;
                //when cur elem equals prev elem => do nothing and keep length as it is
            } else if (nums[end - 1] == nums[end]) {
                curLength = curLength;
            } else { // when cur elem not equals 'prev' and 'prev' elem + 1
                curLength = 1;//we found a diff elem so reassign curLength to 1
            }
            // update max length
            maxLength = Math.max(maxLength, curLength);
        }
        return maxLength;
    }


    /**
     * Optimized Approach
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public static int longestConseutiveSequence1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        Set<Integer> set = new HashSet<>();
        int maxLength = 0;
        // add all the elements in the set
        for (int num : nums) {
            set.add(num);
        }

        // iterate over the nums array and try to find the starting element of a sequence
        // basically check if the cur element's previous element exists or not
        // if not exist then this element could be the starting element of a sequence

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int length = 1;

                while (set.contains(curNum + 1)) {
                    length++;
                    curNum++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        int[] nums1 = {0,3,7,2,5,8,4,6,0,1};
        int result = longestConseutiveSequence1(nums1);
        System.out.println(result);
    }


}
