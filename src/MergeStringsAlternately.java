/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
 * If a string is longer than the other, append the additional letters onto the end of the merged string.
 * Return the merged string.
 * Example 1:
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Example 2:
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 */
public class MergeStringsAlternately {

    /**
     *  What is the range of two string word1 and word2?
     *  will the strings be in all upper or lowercase?
     *
     */

    // Two pointer approach
    public static String merge(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int i = 0;
        int j = 0;

        StringBuilder sb = new StringBuilder();

        while (i < m || j < n) {
            if (i < m) {
                sb.append(word1.charAt(i));
                i++;
            }
            if (j < n) {
                sb.append(word2.charAt(j));
                j++;
            }
        }
        return sb.toString();
    }

    // one pointer approach
    public static String mergeOnePointer(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int i = 0;

        StringBuilder sb = new StringBuilder();

        while (i < m || i < n) {
            if (i < m) {
                sb.append(word1.charAt(i));
            }
            if (i < n) {
                sb.append(word2.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";

        System.out.println(merge(word1, word2));
        System.out.println(mergeOnePointer(word1, word2));
    }

}
