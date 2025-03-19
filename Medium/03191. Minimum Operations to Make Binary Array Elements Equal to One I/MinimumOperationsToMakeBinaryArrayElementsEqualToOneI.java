class Solution {
    public int minOperations(int[] nums) {
        int numsLength = nums.length, operations = 0;

        for (int i = 0; i < numsLength - 2; ++i) {
            if (nums[i] == 0) {
                nums[i] = 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                ++operations;
            }
        }

        return (
            nums[numsLength - 2] == 0 ||
            nums[numsLength - 1] == 0
        ) ? -1 : operations;
    }
}

public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 0, 0};
  
        Solution solution = new Solution();
        int result = solution.minOperations(nums);
  
        System.out.println(result);
    }
}