class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder resultStringBuilder = new StringBuilder();
        int[] digitStack = new int[n + 1];
        int index = 0;
        
        for (int i = 0; i <= n; ++i) {
            digitStack[index++] = i + 1;

            if (i == n || pattern.charAt(i) == 'I') {
                while (index > 0) {
                    resultStringBuilder.append(digitStack[--index]);
                }
            }
        }

        return resultStringBuilder.toString();
    }
}

public class ConstructSmallestNumberFromDIString {
    public static void main(String[] args) {
        String pattern = "IIIDIDDD";

        Solution solution = new Solution();
        String result = solution.smallestNumber(pattern);

        System.out.print(result);
    }
}