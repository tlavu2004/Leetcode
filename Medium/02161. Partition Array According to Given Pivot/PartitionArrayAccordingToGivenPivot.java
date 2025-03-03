class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] resultArray = new int[nums.length];
        int left = 0, right = nums.length - 1;

        for (
            int i = 0, j = nums.length - 1;
            i < nums.length;
            ++i, --j
        ) {
            if (nums[i] < pivot) {
                resultArray[left++] = nums[i];
            }
            
            if (nums[j] > pivot) {
                resultArray[right--] = nums[j];
            }
        }

        while (left <= right) {
            resultArray[left++] = pivot;
        }

        return resultArray;
    }
}

public class PartitionArrayAccordingToGivenPivot {
    public static void main(String[] args) {
        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;

        Solution solution = new Solution();
        int[] result = solution.pivotArray(nums, pivot);

        StringBuilder resultStringBuilder = new StringBuilder();
        resultStringBuilder.append("[");
        for (int i = 0; i < result.length; ++i) {
            resultStringBuilder.append(result[i]).append(i < result.length - 1 ? ", " : "].");
        }

        System.out.println(resultStringBuilder.toString());
    }
}