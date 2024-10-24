package String;

/**
 *Given an array of characters chars, compress it using the following algorithm:
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 * After you are done modifying the input array, return the new length of the array.
 * You must write an algorithm that uses only constant extra space.
 *
 * Example 1:
 * Input: chars = ["a","a","b","b","c","c","c"]
 * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 */
public class CompressString {
    public static int compress(char[] chars) {
        int start = 0;  // represents the index of the first occurrence of a character
        int index = 0;   // index of the compressed char array

        while (start < chars.length) {  //
            char firstChar = chars[start];
            int end = start;
            while (end < chars.length && firstChar == chars[end]) {
                end++;
            }
            chars[index++] = chars[start];
            if (end - start > 1) {
                String counts = end - start + "";
                for (char c : counts.toCharArray()) {
                    chars[index++] = c;
                }
            }
            start = end;
        }
        return index;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'b', 'c', 'c'}; // a2b3c2
        int size = compress(chars);
        System.out.println(size);

    }
}
