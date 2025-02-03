class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int result = 1, increasingLength = 1, decreasingLength = 1;

        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i + 1] > nums[i]) {
                ++increasingLength;
                decreasingLength = 1;
            } else if (nums[i + 1] < nums[i]){
                ++decreasingLength;
                increasingLength = 1;
            } else {
                increasingLength = 1;
                decreasingLength = 1;
            }

            result = Math.max(result, Math.max(increasingLength, decreasingLength));
        }

        return result;
    }
}

public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 3, 2};
        
        Solution solution = new Solution();
        int result = solution.longestMonotonicSubarray(nums);

        System.out.println(result);
    }
}
