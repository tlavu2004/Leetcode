class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int numsLength = nums.length;
        long[] prefixSum = new long[numsLength + 1];

        for (int i = 0; i < numsLength; ++i) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int[] indexMonotonicQueue = new int[numsLength + 1]; // Maximum size possible.
        int left = 0, right = 0, minimumLength = numsLength + 1;

        for (int i = 0; i <= numsLength; ++i) { // i < sum.length (numsLength + 1).
            // prefixSum[i] - prefixSum[indexMonotonicQueue[left]]: sum from number have the index of indexMonotonicQueue[left] to i - 1. 
            while (right > left && prefixSum[i] - prefixSum[indexMonotonicQueue[left]] >= k) {
                minimumLength = Math.min(minimumLength, i - indexMonotonicQueue[left++]);
            }

            while (right > left && prefixSum[i] <= prefixSum[indexMonotonicQueue[right - 1]]) {
                --right;
            }

            indexMonotonicQueue[right++] = i;
        }
        return minimumLength <= numsLength ? minimumLength : -1;
    }
}

public class ShortestSubarrayWithSumAtLeastK {
    public static void main(String[] args) {
        //long[] prefixSum = {0, 2, 1, 3};
        int[] nums = {2, -1, 2};
        int k = 3;

        Solution solution = new Solution();
        int result = solution.shortestSubarray(nums, k);

        System.out.println(result);
    }
}