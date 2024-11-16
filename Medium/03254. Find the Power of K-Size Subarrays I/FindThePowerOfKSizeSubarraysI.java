class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }

        int currentIndexResultsArray = 0, numsLength = nums.length;
        int[] result = new int[numsLength - k + 1];

        int left = 0, right = 1;
        while (right < numsLength && left + k - 1 < numsLength) {
            boolean isNotConsecutive = (nums[right] - nums[right - 1] != 1);

            if (isNotConsecutive) {
                while (left < right && left + k - 1 < numsLength) {
                    result[currentIndexResultsArray++] = -1;
                    ++left;
                }
                left = right;
            } else if (right - left + 1 == k) {
                result[currentIndexResultsArray++] = nums[right];
                ++left;
            }
            ++right;
        }

        return result;
    }
}

public class FindThePowerOfKSizeSubarraysI {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3, 2, 5};
        int k = 3;

        Solution solution = new Solution();
        int[] result = solution.resultsArray(nums, k);

        System.out.print("[");
        for (int i = 0; i < result.length; ++i) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            } else {
                System.out.print("].");
            }
        }
    }
}