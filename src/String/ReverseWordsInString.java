package String;

/**
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words. Do not include any extra spaces.
 * Example 1:
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 * Input: s = "  hello world  "
 * Output: "world hello"
 */
public class ReverseWordsInString {

    // Approach 1
    public static String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            result.append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        String s1 = "  hello world  ";
        String result = reverseWords(s1);
        System.out.println(result);
    }

}
