class Solution {
    public int[] applyOperations(int[] nums) {
        int numsLength = nums.length, nonZeroIndex = 0;

        for (int index = 0; index < numsLength; ++index) {
            if (
                index < numsLength - 1 &&
                nums[index] == nums[index + 1] &&
                nums[index] != 0
            ) {
                nums[index] *= 2;
                nums[index + 1] = 0;
            }

            if (nums[index] != 0) {
                if (index != nonZeroIndex) {
                    swapArrayElements(nums, index, nonZeroIndex);
                }
                ++nonZeroIndex;
            }
        }

        return nums;
    }

    private void swapArrayElements(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =  temp;
    }
}

public class ApplyOperationsToAnArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1, 1, 0};

        Solution solution = new Solution();
        int[] result = solution.applyOperations(nums);
        
        StringBuilder resultStringBuilder = new StringBuilder();
        resultStringBuilder.append("[");
        for (int i = 0; i < result.length; ++i) {
            resultStringBuilder.append(result[i]).append(i < result.length - 1 ? ", " : "].");
        }

        System.out.println(resultStringBuilder.toString());
    }
}