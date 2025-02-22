class Solution {
    public int numTilePossibilities(String tiles) {
        char[] tilesCharArray = tiles.toCharArray();
        return permute(0, tilesCharArray);
    }

    private int permute(int start, char[] arr) {
        if (start == arr.length) {
            return 0;
        }

        int result = 0;
        for (int i = start; i < arr.length; ++i) {
            if (!isPermutedBefore(start, i -1, arr[i], arr)) {
                swap(start, i, arr);
                result += 1 + permute(start + 1, arr);
                swap(start, i, arr);
            }
        }

        return result;
    }

    private boolean isPermutedBefore(int i, int j, char ch, char[] arr) {
        while (i <= j) {
            if (arr[i++] == ch) {
                return true;
            }
        }
        return false;
    }

    private void swap(int i, int j, char[] arr) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

public class LetterTilePossibilities {
    public static void main(String[] args) {
        String tiles = "AAB";

        Solution solution = new Solution();
        int result = solution.numTilePossibilities(tiles);

        System.out.print(result);
    }
}