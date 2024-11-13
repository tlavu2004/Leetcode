import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long result = 0;
        int numsLength = nums.length;
        for (int i = 0; i < numsLength - 1; ++i) {
            int lowerBound = getLowerBound(nums, i + 1, numsLength, lower - nums[i]);
            int upperBound = getUpperBound(nums, i + 1, numsLength, upper - nums[i]);
            result += upperBound - lowerBound;
        }
        return result;
    }

    // Get left boundary
    private int getLowerBound(int[] nums, int left, int right, int target) {
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] >= target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    // Get 1 more position next to right boundary.
    private int getUpperBound(int[] nums, int left, int right, int target) {
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
}

public class CountTheNumberOfFairPairs {
    public static void main(String[] args) {
        int[] nums = {0, 1, 7, 4, 4, 5};
        int lower = 3, upper = 6;

        Solution solution = new Solution();
        long result = solution.countFairPairs(nums, lower, upper);

        System.out.println(result);
    }
}