import java.util.ArrayList;
import java.util.List;
// import java.util.Collections;

class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> values = new ArrayList<>();

        for (int[] row : grid) {
            for (int value : row) {
                values.add(value);
            }
        }

        values.sort(null);
        // Collections.sort(values);

        for (int value : values) {
            if (Math.abs(value - values.get(0)) % x != 0) {
                return -1;
            }
        }

        int median = values.get(values.size() / 2);
        int operations = 0;

        for (int value : values) {
            operations += Math.abs(value - median) / x;
        }

        return operations;
    }
}

public class MinimumOperationsToMakeAUniValueGrid {
    public static void main(String[] args) {
        int[][] grid = {
            {980, 476, 644, 56},
            {644, 140, 812, 308},
            {812, 812, 896, 560},
            {728, 476, 56, 812}
        };
        int x = 84;

        Solution solution = new Solution();
        int result = solution.minOperations(grid, x);

        System.out.println(result);
    }
}