/**
 * Given a 2D integer array matrix, return the transpose of matrix.
 * The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * Example 2:
 * Input: matrix = [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 */
public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        int r = matrix.length; // row
        int c = matrix[0].length; // column

        int[][] result = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] matrix1 = {
                {1,2,3},
                {4,5,6}
        };
        int[][] result = transpose(matrix);
        int[][] result1 = transpose(matrix1);
        printArray(result1);
    }

    private static void printArray(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " "); // rows
            }
            System.out.println(""); // break for next row
        }
    }

}
