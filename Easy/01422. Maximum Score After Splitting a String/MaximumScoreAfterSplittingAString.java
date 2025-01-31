class Solution {
    public int maxScore(String s) {
        int zerosCount = 0, onesCount = 0;
        int bestScore = Integer.MIN_VALUE;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                ++zerosCount;
            } else {
                ++onesCount;
            }

            bestScore = Math.max(bestScore, zerosCount - onesCount);
        }

        if (s.charAt(s.length() - 1) == '1') {
            ++onesCount;
        }

        return bestScore + onesCount;
    }
}

public class MaximumScoreAfterSplittingAString {
    public static void main(String[] args) {
        String s = "011101";

        Solution solution = new Solution();
        int result = solution.maxScore(s);

        System.out.println(result);
    }
}
