import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int minimumObstacles(int[][] grid) {
        int rowLength = grid.length, columnLength = grid[0].length;
        Deque<Integer[]> deque = new ArrayDeque<>();
        int[][] numberOfObstacles = new int[rowLength][columnLength];
        for (int[] row : numberOfObstacles) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int[] directionX = {1, -1, 0, 0}, directionY = {0, 0, 1, -1};

        deque.offer(new Integer[] {0, 0});
        numberOfObstacles[0][0] = 0;
        while (!deque.isEmpty()) {
            Integer[] cell = deque.pollFirst();
            int currentX = cell[0], currentY = cell[1];
            for (int direction = 0; direction < 4; ++direction) {
                int nextX = currentX + directionX[direction];
                int nextY = currentY + directionY[direction];
                if (nextX >= 0 && nextY >= 0 && nextX < rowLength && nextY < columnLength) {
                    int currentNumberOfObstacles = numberOfObstacles[currentX][currentY] + grid[nextX][nextY];
                    if (currentNumberOfObstacles < numberOfObstacles[nextX][nextY]) {
                        numberOfObstacles[nextX][nextY] = currentNumberOfObstacles;
                        if (grid[nextX][nextY] == 0) {
                            deque.offerFirst(new Integer[] {nextX, nextY});
                        } else {
                            deque.offerLast(new Integer[] {nextX, nextY});
                        }
                    }
                }
            }
        }

        return numberOfObstacles[rowLength - 1][columnLength - 1];
    }
}

public class MinimumObstacleRemovalToReachCorner {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1}, {1, 1, 0}, {1, 1, 0}};

        Solution solution = new Solution();
        int result = solution.minimumObstacles(grid);

        System.out.print(result);
    }
}