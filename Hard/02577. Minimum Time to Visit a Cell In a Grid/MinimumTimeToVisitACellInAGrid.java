import java.util.PriorityQueue;

class Solution {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        int rowLength = grid.length, columnLength = grid[0].length;
        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[] directionX = {1, -1, 0, 0}, directionY = {0, 0, 1, -1};
        boolean[][] visited = new boolean[rowLength][columnLength];

        // {row, column, time}.
        priorityQueue.offer(new Integer[] {0, 0, 0});
        visited[0][0] = true;
        while (!priorityQueue.isEmpty()) {
            Integer[] currentCell = priorityQueue.poll();
            Integer row = currentCell[0], column = currentCell[1], time = currentCell[2];

            for (int direction = 0; direction < directionX.length; ++direction) {
                int nextRow = row + directionX[direction];
                int nextColumn = column + directionY[direction];

                if (nextRow < 0 || nextRow >= rowLength ||
                nextColumn < 0 || nextColumn >= columnLength || visited[nextRow][nextColumn]) {
                    continue;
                }

                int nextTime = time + 1;
                if (grid[nextRow][nextColumn] > nextTime) {
                    // Ensures the wait time is adjusted to the nearest even time (same parity).
                    int waitingTime = ((grid[nextRow][nextColumn] - nextTime + 1) / 2) * 2;
                    nextTime += waitingTime;
                }

                if (nextRow == rowLength - 1 && nextColumn == columnLength - 1) {
                    return nextTime;
                }

                visited[nextRow][nextColumn] = true;
                priorityQueue.offer(new Integer[] {nextRow, nextColumn, nextTime});
            }
        }

        return -1;
    }
}

public class MinimumTimeToVisitACellInAGrid {
    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 3, 2}, 
            {5, 1, 2, 5}, 
            {4, 3, 8, 6}
        };

        Solution solution = new Solution();
        int result = solution.minimumTime(grid);
        
        System.out.print(result);
    }
}