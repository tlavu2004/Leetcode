class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int minimumPrefixSum = 0;
        int maximumPrefixSum = 0;
        int prefixSum = 0;

        for (int num: nums) {
            prefixSum += num;
            minimumPrefixSum = Math.min(minimumPrefixSum, prefixSum);
            maximumPrefixSum = Math.max(maximumPrefixSum, prefixSum);
        }

        return maximumPrefixSum - minimumPrefixSum;
    }
}

public class MaximumAbsoluteSumOfAnySubarray {
    public static void main(String[] args) {
        int[] nums = {1, -3, 2, 3, -4};

        Solution solution = new Solution();
        int result = solution.maxAbsoluteSum(nums);
        
        System.out.println(result);
    }
}