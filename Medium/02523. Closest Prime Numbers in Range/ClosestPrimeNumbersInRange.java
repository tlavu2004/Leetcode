import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] closestPrimes(int left, int right) {
        List<Integer> primeNumbers = new ArrayList<>();

        // Find all prime numbers in the given range
        for (int candidate = left; candidate <= right; candidate++) {
            if (candidate % 2 == 0 && candidate > 2) {
                continue;
            }
            if (isPrime(candidate)) {
                // If a twin prime (or [2, 3]) is found, return immediately
                if (
                    !primeNumbers.isEmpty() &&
                    candidate <= primeNumbers.get(primeNumbers.size() - 1) + 2
                ) {
                    return new int[] {
                        primeNumbers.get(primeNumbers.size() - 1),
                        candidate,
                    };
                }
                primeNumbers.add(candidate);
            }
        }

        // If fewer than 2 primes exist, return {-1, -1}
        if (primeNumbers.size() < 2) {
            return new int[] { -1, -1 };
        }

        // Find the closest prime pair
        int[] closestPair = new int[] { -1, -1 };
        int minDifference = 1000000;
        for (int index = 1; index < primeNumbers.size(); index++) {
            int difference =
                primeNumbers.get(index) - primeNumbers.get(index - 1);
            if (difference < minDifference) {
                minDifference = difference;
                closestPair = new int[] {
                    primeNumbers.get(index - 1),
                    primeNumbers.get(index),
                };
            }
        }

        return closestPair;
    }

    // Optimized isPrime function.
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}

public class ClosestPrimeNumbersInRange {
    public static void main(String[] args) {
        int left = 10, right = 19;

        Solution solution = new Solution();
        int[] result = solution.closestPrimes(left, right);

        StringBuilder resultStringBuilder = new StringBuilder();
        resultStringBuilder.append("[");
        for (int i = 0; i < result.length; ++i) {
            resultStringBuilder.append(result[i]).append(i < result.length - 1 ? ", " : "].");
        }

        System.out.println(resultStringBuilder.toString());
    }
}