class Solution {
    public boolean canChange(String start, String target) {
        if (start.equals(target)) {
            return true;
        }

        int pendingL = 0, waitingR = 0, startLength = start.length();
        for (int i = 0; i < startLength; ++i) {
            char currentChar = start.charAt(i), goalChar = target.charAt(i);
            if (currentChar == 'R') {
                if (pendingL > 0) {
                    return false;
                }
                ++waitingR;
            }

            if (goalChar == 'L') {
                if (waitingR > 0) {
                    return false;
                }
                ++pendingL;
            }
            
            if (goalChar == 'R') {
                if (waitingR == 0) {
                    return false;
                }
                --waitingR;
            }

            if (currentChar == 'L') {
                if (pendingL == 0) {
                    return false;
                }
                --pendingL;
            }
        }

        return pendingL == 0 && waitingR == 0;
    }
}

public class MovePiecesToObtainAString {
    public static void main(String[] args) {
        String start = "_L__R__R_", target = "L______RR";

        Solution solution = new Solution();
        boolean result = solution.canChange(start, target);

        System.out.print(result);
    }
}