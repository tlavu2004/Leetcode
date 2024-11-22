import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> filppedRowsCounter = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder keyRow = new StringBuilder();

            // Synchronize all rows begin with 0
            if (row[0] == 1) {
                for (int cell : row) {
                    keyRow.append(cell == 0 ? 1 : 0);
                }
            } else {
                for (int cell : row) {
                    keyRow.append(cell);
                }
            }

            filppedRowsCounter.merge(keyRow.toString(), 1, Integer::sum);
        }

        return Collections.max(filppedRowsCounter.values());
    }
}

public class FlipColumnsForMaximumNumberOfEqualRows {
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};

        Solution solution = new Solution();
        int result = solution.maxEqualRowsAfterFlips(matrix);

        System.out.print(result);
    }
}