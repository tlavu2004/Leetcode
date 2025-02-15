class Solution {
    public boolean canPartition(int num, int target) {
        if (target < 0 || num < target) {
            return false;
        }

        if (num == target) {
            return true;
        }

        // Constraints: 1 <= n <= 1000
        return (
            canPartition(num / 10, target - num % 10) ||
            canPartition(num / 100, target - num % 100) ||
            canPartition(num / 1000, target - num % 1000)
        );
    }

    public int punishmentNumber(int n) {
        int punishmentNumber = 0;

        for (int currentNumber = 1; currentNumber <= n; ++currentNumber) {
            int squareCurrentNumber = currentNumber * currentNumber;
            if (canPartition(squareCurrentNumber, currentNumber)) {
                punishmentNumber += squareCurrentNumber;
            }
        }

        return punishmentNumber;
    }
}

public class FindThePunishmentNumberOfAnInteger {
    public static void main(String[] args) {
        int n = 10;

        Solution solution = new Solution();
        int result = solution.punishmentNumber(n);

        System.out.print(result);
    }
}