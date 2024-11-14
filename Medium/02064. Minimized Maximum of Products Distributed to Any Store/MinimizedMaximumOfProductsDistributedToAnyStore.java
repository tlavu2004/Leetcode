import java.util.Arrays;

class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = Arrays.stream(quantities).max().getAsInt();
        while (left < right) {
            int middle = left + (right - left) / 2, needed = 0;
            for (int quantity : quantities) {
                // Round up (get the maximum store as posible).
                needed += (quantity + middle - 1) / middle;
            }

            if (needed <= n) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }
}

public class MinimizedMaximumOfProductsDistributedToAnyStore {
    public static void main(String[] args) {
        int n = 6;
        int[] quantities = {11, 6};

        Solution solution = new Solution();
        int result = solution.minimizedMaximum(n, quantities);

        System.out.println(result);
    }
}
