import java.util.PriorityQueue;

class Solution {
    public int minOperations(int[] nums, int k) {
        // Just add numbers to priority queue that are lower than k to optimize.
        int operations = 0;
        PriorityQueue<Integer> minimumHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (num < k) {
                minimumHeap.add(num);
            }
        }

        while (!minimumHeap.isEmpty()) {
            int x = minimumHeap.poll();
            ++operations;
            if (minimumHeap.isEmpty()) {
                break;
            }
            int y = minimumHeap.poll();
            long addNumber = 2L * x + y;
            if (addNumber < k) {
                minimumHeap.add((int)addNumber);
            }
        }

        return operations;
    }
}

public class MinimumOperationsToExceedThresholdValueII {
    public static void main(String[] args) {
        //int[] nums = {2, 11, 10, 1, 3};
        //int k = 10;
        int[] nums = {999999999, 999999999, 999999999};
        int k = 1000000000;

        Solution solution = new Solution();
        int result = solution.minOperations(nums, k);

        System.out.print(result);
    }
}