class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long result = 0;
        int numberOfNegativeValue = 0;
        for (int[] row : matrix) {
            for (int cell : row) {
                result += Math.abs(cell);
                numberOfNegativeValue = (cell < 0) ? numberOfNegativeValue + 1 : numberOfNegativeValue;
            }
        }

        if (numberOfNegativeValue % 2 == 0) {
            return result;
        }
        return result - 2 * getMinimumAbsoluteValue(matrix);
    }

    private int getMinimumAbsoluteValue(int[][] matrix) {
        int result = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int cell : row) {
                result = Math.min(result, Math.abs(cell));
            }
        }
        return result;
    }
}

public class MaximumMatrixSum {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {-1, -2, -3}, {1, 2, 3}};

        Solution solution = new Solution();
        long result = solution.maxMatrixSum(matrix);

        System.out.print(result);
    }
}