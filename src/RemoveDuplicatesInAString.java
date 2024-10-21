import java.util.*;
/**
 * String s = "abccbdbga"
 */
public class RemoveDuplicatesInAString {
    /**
     * Time complexity - O(N) - Since we are iterating over all the N number of characters in the string
     * Space Complexity - O(N) - if the given string contains all types of characters i.e (a-z,A-Z,1-9,any symbols)
     *                    O(1) - if the given string is only lowercase/ uppercase alphabets, as we know there are 26 letters so in that case it would be constant
     *
     */
    public static String removeDuplicates(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        String result = "";
        for (char c : set) {
            result += c;
        }
        return result;
    }

    /**
     * Brute Force Approach
     * boolean seen array of fixed size 128 which tracks the characters value according to ASCII code
     * ASCII Table - a-z(97-122) A-Z(65-90) 0-9(48-57)
     * Time Complexity - 0(n)
     * Space complexity - O(1) as we are using the boolean array of fixed size
     */
    public static String removeDuplicates1(String s) {
        boolean[] seen = new boolean[128];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!seen[c]) {
                result.append(c);
                seen[c] = true;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "abccbdbga";
        System.out.println(removeDuplicates(s));
        System.out.println(removeDuplicates1(s));
    }
}
