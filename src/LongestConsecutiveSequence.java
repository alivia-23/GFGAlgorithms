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
    public int longestConsecutive(int[] nums) {
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


}
