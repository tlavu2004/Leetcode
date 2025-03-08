class Solution {
    public int minimumRecolors(String blocks, int k) {
        int left = 0, whiteBlockInRange = 0, operations = Integer.MAX_VALUE;

        for (int right = 0; right < blocks.length(); ++right) {
            if (blocks.charAt(right) == 'W') {
                ++whiteBlockInRange;
            }

            if (right - left + 1 == k) {
                operations = Math.min(operations, whiteBlockInRange);
                if (blocks.charAt(left) == 'W') {
                    --whiteBlockInRange;
                }
                ++left;
            }
        }

        return operations;
    }
}

public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    public static void main(String[] args) {
        String blocks = "WBBWWBBWBW";
        int k = 7;

        Solution solution = new Solution();
        int result = solution.minimumRecolors(blocks, k);

        System.out.println(result);
    }
}