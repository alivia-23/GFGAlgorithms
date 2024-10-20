import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, return true if a permutation of the string could form a
 * palindrome
 *  and false otherwise.
 * Example 1:
 * Input: s = "code"
 * Output: false
 * Example 2:
 * Input: s = "aab"
 * Output: true
 * Example 3:
 * Input: s = "carerac"
 * Output: true
 *
 * Approach:
 * frequencymap -> keeps track of the character and it's count
 * if all char count % 2 == 0 -> true
 * also atmost 1 char count should be 1
 * keep a variable which tracks the number of odd counts
 */
public class PalindromePermutation {
    public static boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0; // counts the number of odd characters

        for (char key : map.keySet()) {
            int count = map.get(key);
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        if (oddCount > 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "carerac";
        String s1 = "code";
        System.out.println(canPermutePalindrome(s));
        System.out.println(canPermutePalindrome(s1));
    }
}
