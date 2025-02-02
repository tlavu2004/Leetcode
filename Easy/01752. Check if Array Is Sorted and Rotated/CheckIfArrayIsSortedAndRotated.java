class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        if (n <= 1) return true;

        int inversionCount = 0;

        for (int i = 1; i < n; ++i) {
            if (nums[i] < nums[i - 1]) {
                ++inversionCount;
            }
        }

        if (nums[0] < nums[n - 1]) {
            ++inversionCount;
        }

        return inversionCount <= 1;
    }
}

public class CheckIfArrayIsSortedAndRotated {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};

        Solution solution = new Solution();
        boolean result = solution.check(nums);
        
        System.out.println(result);
    }
}
