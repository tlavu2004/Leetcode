import java.util.HashMap;
import java.util.Map;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int numsLength = nums.length;
        Map<Integer, Integer> previousIndex = new HashMap<>();
        long result = 0, currrentSum = 0;

        int left = 0;
        for (int right = 0; right < numsLength; ++right) {
            currrentSum +=nums[right];
            int previous_index = previousIndex.getOrDefault(nums[right], -1);

            // Actually: right - left + 1 > k
            while (left <= previous_index || right - left >= k) {
                currrentSum -= nums[left];
                ++left;
            }

            if (right - left + 1 == k) {
                result = Math.max(result, currrentSum);
            }

            previousIndex.put(nums[right], right);
        }

        return result;
    }
}

public class MaximumSumOfDistinctSubarraysWithLengthK {
    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;

        Solution solution = new Solution();
        long result = solution.maximumSubarraySum(nums, k);

        System.out.println(result);
    }
}