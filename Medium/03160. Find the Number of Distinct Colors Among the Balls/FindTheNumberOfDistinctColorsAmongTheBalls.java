import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];

        Map<Integer, Integer> ballMap = new HashMap<>();
        Map<Integer, Integer> colorMap = new HashMap<>();
        
        for (int i = 0; i < n; ++i) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballMap.containsKey(ball)) {
                int previousColor = ballMap.get(ball);
                colorMap.put(previousColor, colorMap.get(previousColor) - 1);

                if (colorMap.get(previousColor) == 0) {
                    colorMap.remove(previousColor);
                }
            }

            ballMap.put(ball, color);
            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
            result[i] = colorMap.size();
        }

        return result;
    }
}

public class FindTheNumberOfDistinctColorsAmongTheBalls {
    public static void main(String[] args) {
        int limit = 4;
        int[][] queries = {{1, 4}, {2,5}, {1, 3}, {3, 4}};

        Solution solution = new Solution();
        int[] result = solution.queryResults(limit, queries);

        System.out.print("[");
        for (int i = 0; i < result.length; ++i) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            } else {
                System.out.print("].");
            }
        }
    }
}