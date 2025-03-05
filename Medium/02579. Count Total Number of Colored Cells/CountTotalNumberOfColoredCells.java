class Solution {
    public long coloredCells(int n) {
        return 2L * n * (n - 1) + 1;
    }
}

public class CountTotalNumberOfColoredCells {
    public static void main(String[] args) {
        int n = 3;

        Solution solution = new Solution();
        long result = solution.coloredCells(n);

        System.out.println(result);
    }
}