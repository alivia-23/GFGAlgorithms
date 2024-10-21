/**
 * Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * Example 1:
 * Input: columnNumber = 1
 * Output: "A"
 * Example 2:
 * Input: columnNumber = 28
 * Output: "AB"
 */
public class ExcelColumnTitle {
    public static String convertExcelNumToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int rem = columnNumber % 26;
            char c = (char) ('A' + rem);
            sb.append(c);
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int columnNumber = 701;
        System.out.println(convertExcelNumToTitle(columnNumber));
    }
}
