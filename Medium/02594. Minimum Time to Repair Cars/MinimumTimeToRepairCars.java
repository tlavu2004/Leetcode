import java.util.Arrays;

class Solution {
    public long repairCars(int[] ranks, int cars) {
        // Narrow down the case, no need to use 0 and max().
        long left = 1;
        long right = (long)Arrays.stream(ranks).min().getAsInt() * cars * cars; 

        while (left < right) {
            long middle = left + (right - left) / 2;
            if (canRepairAllCars(ranks, cars, middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    private boolean canRepairAllCars(int[] ranks, int cars, long time) {
        long totalCarsRepaired = 0;

        for (int rank : ranks) {
            totalCarsRepaired += Math.sqrt(time / rank);
            if (totalCarsRepaired >= cars) {
                return true;
            }
        }

        return false;
    }
}

public class MinimumTimeToRepairCars {
    public static void main(String[] args) {
        int[] ranks = {4, 3, 2, 1};
        int cars = 10;

        Solution solution = new Solution();
        long result = solution.repairCars(ranks, cars);

        System.out.println(result);
    }
}
