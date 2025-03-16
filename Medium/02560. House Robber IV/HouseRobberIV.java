import java.util.Arrays;

class Solution {
    public int minCapability(int[] nums, int k) {
        int left = Arrays.stream(nums).min().getAsInt();
        int right = Arrays.stream(nums).max().getAsInt();

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (canStealKHouses(nums, k, middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    private boolean canStealKHouses(int[] nums, int k, int capability) {
        int countHouses = 0, totalHouses = nums.length, i = 0;

        while (i < totalHouses) {
            if (nums[i] <= capability) {
                ++countHouses;
                i += 2;
            } else {
                ++i;
            }
        }

        return (countHouses >= k);
    }
}

public class HouseRobberIV {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 9};
        int k = 2;

        Solution solution = new Solution();
        int result = solution.minCapability(nums, k);

        System.out.println(result);
    }
}