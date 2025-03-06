class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int gridSideLength = grid.length;
        long fullGridSum = 
            (long)gridSideLength * gridSideLength * (gridSideLength * gridSideLength + 1) / 2;
        long fullGridSumOfSquares = 
            (long)gridSideLength * gridSideLength * (gridSideLength * gridSideLength + 1) *
            (2 * gridSideLength * gridSideLength + 1) / 6;
        long actualGridSum = 0, actualGridSumOfSquares = 0;

        for (int[] row : grid) {
            for (int number : row) {
                actualGridSum += (long)number;
                actualGridSumOfSquares += (long)number * number;
            }
        }

        long diffGridSum = actualGridSum - fullGridSum; // (a - b)
        long diffGridSumOfSquares = actualGridSumOfSquares - fullGridSumOfSquares; // a^2 - b^2 = (a - b)(a + b)
        long sumOfMissingAndDuplicateNumbers = diffGridSumOfSquares / diffGridSum; // (a + b)

        int duplicateNumbers = (int)((sumOfMissingAndDuplicateNumbers + diffGridSum) / 2);
        int missingNumbers = (int)((sumOfMissingAndDuplicateNumbers - diffGridSum) / 2);

        return new int[]{duplicateNumbers, missingNumbers};
    }
}

public class FindMissingAndRepeatedValues {
    public static void main(String[] args) {
        int[][] grid = {{9, 1, 7}, {8, 9, 2}, {3, 4, 6}};

        Solution solution = new Solution();
        int[] result = solution.findMissingAndRepeatedValues(grid);

        StringBuilder resultStringBuilder = new StringBuilder();
        resultStringBuilder.append("[");
        for (int i = 0; i < result.length; ++i) {
            resultStringBuilder.append(result[i]).append(i < result.length - 1 ? ", " : "].");
        }

        System.out.println(resultStringBuilder.toString());
    }
}