import java.util.List;
import java.util.Vector;

class Solution {
    public boolean primeSubOperation(int[] nums) {
        int previousElement = 0;
        for (int num : nums) {
            if (num <= previousElement) {
                return false;
            }
            int largestPrimeLessThanUpperBound = getLargestPrimeLessThan(num - previousElement);
            if (largestPrimeLessThanUpperBound != -1) {
                num -= largestPrimeLessThanUpperBound;
            }
            previousElement = num;
        }
        return true;
    }

    private List<Integer> getPrimesListLessThanOrEqualTo(int upperBound) {
        List<Integer> result = new Vector<>();
        for (int i = 2; i <= upperBound; ++i) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; ++j) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                result.add(i);
            }
        }

        return result;
    }

    private int getLargestPrimeLessThan(int number) {
        final int MAX_SIZE = 1000;
        List<Integer> primesList = getPrimesListLessThanOrEqualTo(MAX_SIZE);
        int left = 0, right = primesList.size() - 1;

        if (number <= primesList.get(left)) {
            return -1;
        }
        
        while (left < right) {
            int middle = left + (right - left + 1) / 2;
            if (primesList.get(middle) < number) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }
        return primesList.get(left);
    }
}

public class PrimeSubtractionOperation {
    public static void main(String[] args) {
        int[] nums = {998, 2};
        
        Solution solution = new Solution();
        boolean result = solution.primeSubOperation(nums);

        System.out.println(result);
    }
}