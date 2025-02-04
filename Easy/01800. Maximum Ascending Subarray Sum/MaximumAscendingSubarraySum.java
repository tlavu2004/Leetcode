class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];
        int currentSubarraySum = nums[0];

        for (int currentIndex = 1; currentIndex < nums.length; ++currentIndex) {
            if (nums[currentIndex] <= nums[currentIndex - 1]) {
                maxSum = Math.max(maxSum, currentSubarraySum);
                currentSubarraySum = 0;
            }
            currentSubarraySum += nums[currentIndex];
        }
        return Math.max(maxSum, currentSubarraySum);
    }
}

public class MaximumAscendingSubarraySum {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 5, 10, 50};

        Solution solution = new Solution();
        int result = solution.maxAscendingSum(nums);

        System.out.println(result);
    }
}
