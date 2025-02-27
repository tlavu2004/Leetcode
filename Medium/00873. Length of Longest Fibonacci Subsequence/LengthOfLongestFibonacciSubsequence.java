class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int maximumLength = 0;

        for (int currentIndex = 2; currentIndex < n; ++currentIndex) {
            int start = 0, end = currentIndex - 1;

            while (start < end) {
                int pairSum = arr[start] + arr[end];
                
                if (pairSum > arr[currentIndex]) {
                    --end;
                } else if (pairSum < arr[currentIndex]) {
                    ++start;
                } else {
                    dp[end][currentIndex] = dp[start][end] + 1;
                    maximumLength = Math.max(dp[end][currentIndex], maximumLength);
                    --end;
                    ++start;
                }
            }
        }

        return maximumLength == 0 ? 0 : maximumLength + 2;
    }
}

public class LengthOfLongestFibonacciSubsequence {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        Solution solution = new Solution();
        int result = solution.lenLongestFibSubseq(arr);

        System.out.println(result);
    }
}