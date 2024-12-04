class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int str1Length = str1.length(), str2Length = str2.length();
        char targetCharacter = str2.charAt(0);

        int currentStr1Index = 0, currentStr2Index = 0;
        while (currentStr1Index < str1Length && currentStr2Index < str2Length) {
            char sourceCharacter = str1.charAt(currentStr1Index);
            if (sourceCharacter == targetCharacter || 
                (char)(sourceCharacter + 1) == targetCharacter ||
                sourceCharacter == 'z' && targetCharacter == 'a') {
                ++currentStr2Index;
                if (currentStr2Index < str2Length) {
                    targetCharacter = str2.charAt(currentStr2Index);
                }
            }
            ++currentStr1Index;
        }

        return currentStr2Index == str2Length;
    }
}

public class MakeStringASubsequenceUsingCyclicIncrements {
    public static void main(String[] args) {
        String str1 = "abc", str2 = "ad";

        Solution solution = new Solution();
        boolean result = solution.canMakeSubsequence(str1, str2);

        System.out.print(result);
    }
}