class Solution {
    public String clearDigits(String s) {
        int answerLength = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                answerLength = Math.max(answerLength - 1, 0);
            } else {
                charArray[answerLength++] = s.charAt(i);
            }
        }

        String resultString = new String(charArray, 0 , answerLength);
        return resultString;
    }
}

public class ClearDigits {
    public static void main(String[] args) {
        String s = "a1a";

        Solution solution = new Solution();
        String result = solution.clearDigits(s);

        System.out.print(result);
    }
}