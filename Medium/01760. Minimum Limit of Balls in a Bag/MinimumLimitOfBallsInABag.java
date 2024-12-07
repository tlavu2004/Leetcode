import java.util.Arrays;

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        int result = right;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDivide(nums, mid, maxOperations)) {
                right = mid;
                result = right;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean canDivide(int[] nums, int maxBalls, int maxOperations) {
        int operations = 0;
        for (int num : nums) {
            operations += (num - 1) / maxBalls;
            if (operations > maxOperations) {
                return false;
            }
        }
        return true;
    }
}

public class MinimumLimitOfBallsInABag {
    public static void main(String[] args) {
        int[] nums = {9};
        int maxOperations = 2;

        Solution solution = new Solution();
        int result = solution.minimumSize(nums, maxOperations);

        System.out.print(result);
    }
}