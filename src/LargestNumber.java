import java.util.Arrays;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 * Since the result may be very large, so you need to return a string instead of an integer.
 *
 * Example 1:
 * Input: nums = [10,2]
 * Output: "210"
 *
 * Example 2:
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 *
 * 9534330
 */
public class LargestNumber {
    public static String largestNumber(int[] nums) {
        int n = nums.length;
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(s, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        if (s[0].charAt(0) == '0') return "0";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            sb.append(s[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {10, 2};
        int[] nums1 = {3,30,34,5,9};
        int[] nums2 = {0,0};
        System.out.println(largestNumber(nums));
        System.out.println(largestNumber(nums1));
        System.out.println(largestNumber(nums2));
    }

}
