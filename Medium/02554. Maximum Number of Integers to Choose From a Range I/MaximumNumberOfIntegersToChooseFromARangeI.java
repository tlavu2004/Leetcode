class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int[] isBanned = new int[10001];
        for (int i = 0; i < banned.length; i++) {
            isBanned[banned[i]] = 1;
        }

        long currentSum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isBanned[i] == 1) {
                continue;
            }

            currentSum += i;
            if (currentSum > maxSum) {
                break;
            }

            ++count;
        }

        return count;
    }
}

public class MaximumNumberOfIntegersToChooseFromARangeI {
    public static void main(String[] args) {
        int[] banned = {
            176, 36, 104, 125, 188, 152, 101, 47, 51, 65, 39, 174, 29, 55, 13, 138,
            79, 81, 175, 178, 42, 108, 24, 80, 183, 190, 123, 20, 139, 22, 140, 62, 
            58, 137, 68, 148, 172, 76, 173, 189, 151, 186, 153, 57, 142, 105, 133, 114,
            165, 118, 56, 59, 124, 82, 49, 94, 8, 146, 109, 14, 85, 44, 60, 181, 
            95, 23, 150, 97, 28, 182, 157, 46, 160, 155, 12, 67, 135, 117, 2, 25,
            74, 91, 71, 98, 127, 120, 130, 107, 168, 18, 69, 110, 61, 147, 145, 38
        };                        
        int n = 3016, maxSum = 240;

        Solution solution = new Solution();
        int result = solution.maxCount(banned, n, maxSum);

        System.out.print(result);
    }
}