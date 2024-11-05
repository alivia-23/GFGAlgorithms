package String;
import java.util.*;

/**
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 * Example 1:
 * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
 * Output: true
 * Explanation: sentence contains at least one of every letter of the English alphabet.
 * Example 2:
 * Input: sentence = "leetcode"
 * Output: false
 */
public class CheckPangram {
    public boolean checkIfPangram(String sentence) {
        Set<Integer> set = new HashSet<>();

        for (char c : sentence.toCharArray()) {
            int asciiValue = c;
            set.add(asciiValue);
        }
        for (int i = 97; i < 123; i++) {
            if (!set.contains(i)) {
                return false;
            }
        }
        return true;
    }

}
