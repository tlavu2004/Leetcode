import java.util.Stack;

class Solution {
    public String getHappyString(int n, int k) {
        Stack<String> stringStack = new Stack<>();
        int indexInSortedList = 0;
        stringStack.push("");

        while (stringStack.size() > 0) {
            String currentString = stringStack.pop();

            if (currentString.length() == n) {
                ++indexInSortedList;
                if (indexInSortedList == k) {
                    return currentString;
                }
                continue;
            }

            for (char currentChar = 'c'; currentChar >= 'a'; --currentChar) {
                if (
                    currentString.length() == 0 ||
                    currentString.charAt(currentString.length() - 1) != currentChar
                ) {
                    stringStack.push(currentString + currentChar);
                }
            }
        }

        return "";
    }
}

public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {
    public static void main(String[] args) {
        int n = 3, k = 9;

        Solution solution = new Solution();
        String result = solution.getHappyString(n, k);

        System.out.print(result);
    }
}