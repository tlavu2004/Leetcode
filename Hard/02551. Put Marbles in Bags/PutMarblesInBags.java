import java.util.ArrayList;
import java.util.List;

class Solution {
    public long putMarbles(int[] weights, int k) {
        if (k == 1) {
            return 0;
        }

        List<Integer> pairSum = new ArrayList<>();
        for (int i = 0; i < weights.length - 1; i++) {
            pairSum.add(weights[i] + weights[i + 1]);
        }

        pairSum.sort((a, b) -> Integer.compare(a, b));

        long minimumScore = 0, maximumScore = 0;
        for (int i = 0; i < k - 1; i++) {
            minimumScore += pairSum.get(i);
            maximumScore += pairSum.get(pairSum.size() - 1 - i);
        }

        return maximumScore - minimumScore;
    }
}

public class PutMarblesInBags {
    public static void main(String[] args) {
        int[] weights = {1, 3, 5, 1};
        int k = 2;

        Solution solution = new Solution();
        long result = solution.putMarbles(weights, k);

        System.out.println(result); // Expected output: 4
    }
}