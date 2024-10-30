import java.util.*;
/**
 * Given two version strings, version1 and version2, compare them. A version string consists of revisions separated by dots '.'.
 * The value of the revision is its integer conversion ignoring leading zeros.
 * To compare version strings, compare their revision values in left-to-right order. If one of the version strings has fewer revisions,
 * treat the missing revision values as 0.
 * Return the following:
 * If version1 < version2, return -1.
 * If version1 > version2, return 1.
 * Otherwise, return 0.
 *
 * Example 1:
 * Input: version1 = "1.2", version2 = "1.10"
 * Output: -1
 * Explanation:
 * version1's second revision is "2" and version2's second revision is "10": 2 < 10, so version1 < version2.
 * Example 2:
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation:
 * Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
 * Example 3:
 * Input: version1 = "1.0", version2 = "1.0.0.0"
 * Output: 0
 */
public class CompareVersionNumber {

    public static int compareVersions(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int m = s1.length;
        int n = s2.length;
        int maxLength = Math.max(m, n);

        for (int i = 0; i < maxLength; i++) {
            // First convert each version string from the string arrays to interger and if the length of the array exited and the
            // other string array elements are still there to compare then replace the previous with 0
            int v1, v2;
            if (i < m) {
                v1 = Integer.parseInt(s1[i]);
            } else {
                v1 = 0;
            }
            if (i < n) {
                v2 = Integer.parseInt(s2[i]);
            } else {
                v2 = 0;
            }
            if (v1 != v2) {
                return v1 < v2 ? -1 : 1;
            }
        }
        return 0;
    }


    public static void print(String[] nums) {
        for (String s : nums) {
            System.out.print(s + " ");
        }
    }

    public static void main(String[] args) {
//        String version1 = "1.2";
//        String version2 = "1.10";

        String version1 = "1.01";
        String version2 = "1.001";
        int result = compareVersions(version1, version2);
        System.out.println(result);
    }

}
