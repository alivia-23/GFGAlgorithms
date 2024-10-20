import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 *
 * Note :-
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (map1.containsKey(sChar) && map1.get(sChar) != tChar) {
                return false;
            }
            if (map2.containsKey(tChar) && map2.get(tChar) != sChar) {
                return false;
            }
            map1.put(sChar, tChar);
            map2.put(tChar, sChar);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        String s1 = "foo";
        String t1 = "bar";
        System.out.println(isIsomorphic(s, t));
        System.out.println(isIsomorphic(s1, t1));
    }
}
