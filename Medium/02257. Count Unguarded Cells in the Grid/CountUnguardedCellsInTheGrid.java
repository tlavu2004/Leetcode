class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // Marking rule:
        //     - 0: unguarded
        //     - 1: guards
        //     - 2: walls
        //     - -1: guarded
        short[][] grid = new short[m][n];

        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }

        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }

        for (int[] guard : guards) {
            guardCells(grid, m, n, guard[0], guard[1]);
        }

        int result = 0;
        for (short[] row : grid) {
            for (short cell : row) {
                // System.out.print(cell + " ");
                if (cell == 0) {
                    ++result;
                }
            }
            // System.out.println("");
        }

        return result;
    }

    private void guardCells(short[][] grid, int m, int n, int guardRow, int guardColumn) {
        for (int row = guardRow - 1; row >= 0; --row) {
            if (grid[row][guardColumn] == 1 || grid[row][guardColumn] == 2) {
                break;
            }
            grid[row][guardColumn] = -1;
        }

        for (int row = guardRow + 1; row < m; ++row) {
            if (grid[row][guardColumn] == 1 || grid[row][guardColumn] == 2) {
                break;
            }
            grid[row][guardColumn] = -1;
        }

        for (int column = guardColumn - 1; column >= 0; --column) {
            if (grid[guardRow][column] == 1 || grid[guardRow][column] == 2) {
                break;
            }
            grid[guardRow][column] = -1;
        }

        for (int column = guardColumn + 1; column < n; ++column) {
            if (grid[guardRow][column] == 1 || grid[guardRow][column] == 2) {
                break;
            }
            grid[guardRow][column] = -1;
        }
    }
}

public class CountUnguardedCellsInTheGrid {
    public static void main(String[] args) {
        int m = 4, n = 6;
        int[][] guards = { {0, 0}, {1, 1}, {2, 3} };
        int[][] walls = { {0, 1}, {2, 2}, {1, 4} };

        Solution solution = new Solution();
        int result = solution.countUnguarded(m, n, guards, walls);

        System.out.print(result);
    }
}