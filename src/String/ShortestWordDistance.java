package String;

/**
 * Given an array of strings wordsDict and two different strings that already exist in the array word1 and word2,
 * return the shortest distance between these two words in the list.
 * Example 1:
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
 * Output: 3
 * Example 2:
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
 * Output: 1
 */
public class ShortestWordDistance {
    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        int minDistance = wordsDict.length;
        int index1 = -1;
        int index2 = -1;

        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                index1 = i;
            }
            if (wordsDict[i].equals(word2)) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(index2 - index1));
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        String word1 = "coding";
        String word2 = "practice";
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        int minDistance = shortestDistance(wordsDict, word1, word2);
        System.out.println(minDistance);
    }
}
