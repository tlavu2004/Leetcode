import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> mapNumPairs = new HashMap<>();

        for (int num : nums) {
            mapNumPairs.put(num, mapNumPairs.getOrDefault(num, 0) + 1);
        }

        for (int value : mapNumPairs.values()) {
            if (value % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}

public class DivideArrayIntoEqualPairs {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 2, 2, 2};

        Solution solution = new Solution();
        boolean result = solution.divideArray(nums);
        
        System.out.println(result);
    }
}