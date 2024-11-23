import java.util.Arrays;

class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int boxRowSize = box.length, boxColumnSize = box[0].length;
        char[][] result = new char[boxColumnSize][boxRowSize];
        for (char[] row : result) {
            Arrays.fill(row, '.');
        }

        for (int currentBoxRow = 0; currentBoxRow < boxRowSize; ++currentBoxRow)  {
            int aboveNearestObstacle = boxColumnSize - 1;
            for (int currentBoxColumn = boxColumnSize - 1; currentBoxColumn >= 0; --currentBoxColumn) {
                if (box[currentBoxRow][currentBoxColumn] == '#') {
                    result[aboveNearestObstacle][boxRowSize - 1 - currentBoxRow] = '#';
                    --aboveNearestObstacle;
                } else if (box[currentBoxRow][currentBoxColumn] == '*') {
                    result[currentBoxColumn][boxRowSize - 1 - currentBoxRow] = '*';
                    aboveNearestObstacle = currentBoxColumn - 1;
                }
            }
        }
        return result;
    }
}

public class RotatingTheBox {
    public static void main(String[] args) {
        char[][] box =   {{'#', '.', '*', '.'},
                         {'#', '#', '*', '.'}};

        Solution solution = new Solution();
        char[][] result = solution.rotateTheBox(box);

        int rowSize = result.length, columnSize = result[0].length;
        System.out.print("[");
        for (int i = 0; i < rowSize; ++i) {
            if (i == 0) {
                System.out.print("[");
            } else {
                System.out.print(" [");
            }

            for (int j = 0; j < columnSize; ++j) {
                System.out.print("\"" + result[i][j] + "\"");
                if (j < columnSize - 1) {
                    System.out.print(", ");
                } else if (i < rowSize - 1) {
                    System.out.println("],");
                } else {
                    System.out.print("]");
                }
            }
        }
        System.out.print("].");
    }
}