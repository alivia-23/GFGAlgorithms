package MatrixProblems;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length; // rows
        int n = matrix[0].length; // cols
        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd = m - 1;
        int colEnd = n - 1;
        List<Integer> result = new ArrayList<>();

        while (rowBegin <= rowEnd && colBegin <= colEnd) {

            // Traverse Right
            for (int j = colBegin; j <= colEnd; j++) {
                result.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int i = rowBegin; i >= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            // Traverse left
            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    result.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }


            // Traverse Up
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i++) {
                    result.add(matrix[i][colBegin]);
                }
                colBegin++;
            }

        }
        return result;
    }
}
