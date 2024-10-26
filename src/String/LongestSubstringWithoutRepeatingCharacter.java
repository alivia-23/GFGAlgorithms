package String;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char curChar = s.charAt(end);
            while (set.contains(curChar)) {
                char startChar = s.charAt(start);
                set.remove(startChar);
                start++;
            }
            set.add(curChar);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s1 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring(s1));
    }
}
