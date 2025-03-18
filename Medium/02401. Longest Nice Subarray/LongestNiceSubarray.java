class Solution {
    public int longestNiceSubarray(int[] nums) {
        int numsLength = nums.length, left = 0;
        int longestSubarrayLength = 1, usedBitsArray = 0;

        for (int right = 0; right < numsLength; ++right) {
            while ((usedBitsArray & nums[right]) != 0) {
                usedBitsArray ^= nums[left];
                ++left;
            }

            usedBitsArray |= nums[right];
            longestSubarrayLength = Math.max(longestSubarrayLength, right - left + 1);
        }

        return longestSubarrayLength;
    }
}

public class LongestNiceSubarray {
    public static void main(String[] args) {
        int[] nums = {1, 3, 8, 48, 10};
 
        Solution solution = new Solution();
        int result = solution.longestNiceSubarray(nums);
 
        System.out.println(result);
    }
}