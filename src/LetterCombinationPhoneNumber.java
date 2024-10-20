import java.util.*;
/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 * Input: digits = ""
 * Output: []
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 * Approach:-
 * Map -> hold the digits to string mappings
 * recursively generate the combination string by traversing index by index from the digits string and append one character from each digit
 * when we reach end of the index of digits string we add the result combination in our result list
 * this operation will continue until we generate all possible combinations from the digits
 *
 * Time Complexity - O(N * 4^N)
 * Space Complexity - O(N) where N is the length of the digits
 *
 */
public class LetterCombinationPhoneNumber {
    private static Map<Character, String> map = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        backtrack(0, sb, digits, result);
        return result;
    }

    private static void backtrack(int index, StringBuilder sb, String digits, List<String> result) {
        // when index reaches end of the digits string
        // that means I have performed current path the combination for all the digits in the digits string
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String lettersMappedToDigits = map.get(digits.charAt(index));
        for (char c : lettersMappedToDigits.toCharArray()) {
            sb.append(c);  // append the char in sb
            backtrack(index + 1, sb, digits, result); //call the funcion again passing this sb and next index to append next digit's character
            sb.deleteCharAt(sb.length() - 1); // remove the char from the stringbuilder otherwise the characters will stay forever for the rest of the combinations
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

}
