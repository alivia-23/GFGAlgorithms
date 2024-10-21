import java.util.HashSet;
import java.util.*;

/**
 * Given a string, determine if the string has all unique characters.
 * Examples :
 * Input : abcd10jk
 * Output : true
 * Input : hutg9mnd!nk9
 * Output : false
 *
 * Questions:
 * 1) is the string contains all alphabets? or mixed of numbers and alphabets?
 * 2) Can the string be empty?
 * add all the character in the set if a character is already present then we return false
 *
 */
public class UniqueCharacterString {

    // Approach with set
    // Time complexity - O(n) - n is the number of elements in the string
    // Space complexity - O(n) - n is the number of elements in the set since we are using set which is an an extra space for storing n elements
    public static boolean isUnique(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    //Approach with Map
    // Time complexity - O(n + n) - O(n)
    // space complexity - O(n)
    public static boolean isUnique1(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char key : map.keySet()) {
            int keyCount = map.get(key);
            if (keyCount > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcd10jk";
        String s1 = "hutg9mnd!nk9";
        String s2 = "";
        String s3 = null;

//        System.out.println(isUnique(s));
//        System.out.println(isUnique(s1));
//        System.out.println(isUnique(s2));
//        System.out.println(isUnique(s3));

        System.out.println(isUnique1(s));
        System.out.println(isUnique1(s1));
        System.out.println(isUnique1(s2));
        System.out.println(isUnique1(s3));
    }

}
