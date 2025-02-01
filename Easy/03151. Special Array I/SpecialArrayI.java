class Solution {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (((nums[i] ^ nums[i-1]) & 1) == 0)
                return false;
        }
        return true;
    }
}

public class SpecialArrayI {
    public static void main(String[] args) {
        int[] nums = {4, 3, 1, 6};

        Solution solution = new Solution();
        boolean result = solution.isArraySpecial(nums);

        System.out.println(result);
    }
}
