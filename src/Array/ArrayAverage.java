package Array;

/**
 *  3 * 4 mstrix
 *  a. Compute row average
 *  b. Compute vol average
 *  c. Compute all elems avg
 */
public class ArrayAverage {
    public static int[][] fillElements() {
        int[][] matrix = new int[3][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int)(Math.random()*100);
            }
        }
        return matrix;
    }

    public static int calculateAverage(int[][] matrix) {
        int sum = 0;

        for (int[] row : matrix) {
            for (int r : row)
                sum += r;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] results = new int[3][4];
        results = fillElements();
        print(results);
    }

    public static void print(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.println(result + " ");
            }
        }
    }

}
