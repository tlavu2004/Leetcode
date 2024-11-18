class Solution {
    public int[] decrypt(int[] code, int k) {
        int codeLength = code.length;
        int[] result = new int[codeLength];

        if (k == 0) {
            return result;
        }

        int windowSum = 0;
        int start = (k > 0) ? 1 : codeLength + k;
        int end = (k > 0) ? k : codeLength - 1;

        for (int i = start; i <= end; ++i) {
            windowSum += code[i % codeLength];
        }

        for (int i = 0; i < codeLength; ++i) {
            result[i] = windowSum;
            windowSum -= code[(start + i) % codeLength];
            windowSum += code[(end + i + 1) % codeLength];
        }

        return result;
    }
}

public class DefuseTheBomb {
    public static void main(String[] args) {
        int[] code = {2, 4, 9, 3};
        int k = -2;

        Solution solution = new Solution();
        int[] result = solution.decrypt(code, k);

        System.out.print("[");
        for (int i = 0; i < result.length; ++i) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            } else {
                System.out.print("].");
            }
        }
    }
}