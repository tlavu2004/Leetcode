import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int slidingPuzzle(int[][] board) {
        String targetResult = "123450", startResult = "";
        for (int[] boardRow : board) {
            for (int boardCell : boardRow) {
                startResult += boardCell;
            }
        }

        int[][] directions = { 
            { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, 
            { 0, 4 }, { 1, 3, 5 }, { 2, 4 }
        };
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(startResult);
        queue.offer(startResult);
        int result = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; ++i) {
                String currentResult = queue.poll();
                if (currentResult.equals(targetResult)) {
                    return result;
                }
                int zeroIndex = currentResult.indexOf('0');
                for (int direction : directions[zeroIndex]) {
                    String nextResult = swap(currentResult,  zeroIndex, direction);
                    if (visited.contains(nextResult)) {
                        continue;
                    }
                    visited.add(nextResult);
                    queue.offer(nextResult);
                }
            }
            ++result;
        }
        return -1;
    }

    private String swap(String string, int first, int second) {
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.setCharAt(first, string.charAt(second));
        stringBuilder.setCharAt(second, string.charAt(first));
        return stringBuilder.toString();
    }
}

public class SlidingPuzzle {
    public static void main(String[] args) {
        int[][] board = {{4, 1, 2}, {5, 0, 3}};

        Solution solution = new Solution();
        int result = solution.slidingPuzzle(board);

        System.out.print(result);
    }
}