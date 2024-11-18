package Array;

/**
 * Given an array of positive numbers and a positive number 'k,' find the maximum sum of any contiguous subarray of size 'k'.
 * Example 1:
 * Input: arr = [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 *
 * Example 2:
 * Input: arr = [2, 3, 4, 1, 5], k=2
 * Output: 7
 */
public class MaxSubArraySumSizeK {
    public static int maxSumSubArray(int[] nums, int k) {
        int start = 0;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            if (end >= k - 1) {
                maxSum = Math.max(sum, maxSum);
                sum -= nums[start];
                start++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 1, 5, 1, 3, 2};
//        int k = 3;
//        System.out.println(maxSumSubArray(nums, k));
        int[] nums = {2, 3, 4, 1, 5};
        int k = 2;
        System.out.println(maxSumSubArray(nums, k));
    }
}
