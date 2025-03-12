class Solution {
    public int maximumCount(int[] nums) {
        return Math.max(
            binarySearch(nums, 0),
            nums.length - binarySearch(nums, 1)
        );
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1, numberOfElementsLessThanTarget = nums.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                numberOfElementsLessThanTarget = mid;
                right = mid - 1;
            }
        }

        return numberOfElementsLessThanTarget;
    }
}

public class MaximumCountOfPositiveIntegerAndNegativeInteger {
    public static void main(String[] args) {
        int[] nums = {-2, -1, -1, 1, 2, 3};

        Solution solution = new Solution();
        int result = solution.maximumCount(nums);

        System.out.println(result);
    }
}