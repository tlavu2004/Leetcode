import java.util.Arrays;

class Solution {
    public String addSpaces(String s, int[] spaces) {
        int stringLength = s.length(), spacesLength = spaces.length;
        char[] result = new char[stringLength + spacesLength];
        char[] sArray = s.toCharArray();
        Arrays.sort(spaces);

        int currentResultIndex = 0, curentSArrayIndex = 0;
        for (int space : spaces) {
            while (curentSArrayIndex < space) {
                result[currentResultIndex++] = sArray[curentSArrayIndex++];
            }
            result[currentResultIndex++] = ' ';
        }

        while (curentSArrayIndex < stringLength) {
            result[currentResultIndex++] = sArray[curentSArrayIndex++];
        }

        return new String(result);
    }
}

public class AddingSpacesToAString {
    public static void main(String[] args) {
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = {8, 13, 15};

        Solution solution = new Solution();
        String result = solution.addSpaces(s, spaces);
        
        System.out.print(result);
    }
}