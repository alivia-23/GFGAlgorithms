import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is happy.
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * Example 1:
 * Input: n = 19
 * Output: true
 * Example 2:
 * Input: n = 2
 * Output: false
 *
 * Time Complexity - O(1) -> Since the range of the number can never be greater than 1000 given
 * Space complexity - O(1)
 *
 */
public class HappyNumber {
    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        int num = n;

        while (!seen.contains(num)) {
            seen.add(num);
            num = getSqrSum(num);
            if (num == 1) {
                return true;
            }
        }
        return false;
    }

    private static int getSqrSum(int num) {
        int sum = 0;

        while (num != 0) {
            int rem = num % 10;
            sum += rem * rem;
            num = num / 10;
        }
        return sum;
    }

}
