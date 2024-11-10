import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            int complement = target - nums[i];
            if (numsMap.containsKey(complement)) {
                return new int[] {numsMap.get(complement), i};
            }

            numsMap.put(nums[i], i);
        }

        return new int[] {};
    }
}

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        Solution solution = new Solution();
        int[] result = solution.twoSum(nums, target);

        if (result.length == 2) {
            System.out.println("[" + result[0] + ", " + result[1] + "].");
        } else {
            System.out.println("No matching pairs were found.");
        }
    }
}
