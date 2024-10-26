package String;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 *
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 */
public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int i = 0; // loops through s
        int j = 0; // loops through t
        int m = s.length();
        int n = t.length();

        while (i < m && j < n) {
            if (s.charAt(i) != t.charAt(j)) {
                j++;
            } else {
                i++;
                j++;
            }
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
