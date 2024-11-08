/**
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
 * You must not use any built-in exponent function or operator.
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 *
 * Example 1:
 * Input: x = 4
 * Output: 2
 *
 * Example 2:
 * Input: x = 8
 * Output: 2
 */
public class SquareRootOfANumber {
    public static int findSqrt(int x) {
        if (x < 2) return x;
        int upperBound = x / 2;
        int left = 2;
        int right = upperBound;

        while (left < right) {
            int mid = left + (right - left) / 2;
            long midSqrVal = (long) mid * mid;
            if (midSqrVal == x) {
                return mid;
            } else if (midSqrVal > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
    public static void main(String[] args) {
        int x = 25;
        int sqrRoot = findSqrt(x);
        System.out.println(sqrRoot);
    }
}


