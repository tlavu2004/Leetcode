import java.util.Map;
import java.util.HashMap;

class Solution {
    public long countBadPairs(int[] nums) {
        // j - i != nums[j] - nums[i] => nums[i] - i != nums[j] - j (= different)
        long badPairsCount = 0;
        Map<Integer, Integer> differencesCount = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            int different = nums[i] - i;
            int localGoodPairsCount = differencesCount.getOrDefault(different, 0);
            badPairsCount += i - localGoodPairsCount;
            differencesCount.put(different, localGoodPairsCount + 1);
        }

        return badPairsCount;
    }
}

public class CountNumberOfBadPairs {
    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 3};

        Solution solution = new Solution();
        long result = solution.countBadPairs(nums);

        System.out.print(result);
    }
}