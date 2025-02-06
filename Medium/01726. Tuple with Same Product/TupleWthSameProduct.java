import java.util.Map;
import java.util.HashMap;

class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productCount = new HashMap<>();
        int result = 0;

        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int product = nums[i] * nums[j];
                result += 8 * productCount.getOrDefault(product, 0);
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }

        return result;
    }
}

public class TupleWthSameProduct {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 10};

        Solution solution = new Solution();
        int result = solution.tupleSameProduct(nums);

        System.out.println(result);
    }
}