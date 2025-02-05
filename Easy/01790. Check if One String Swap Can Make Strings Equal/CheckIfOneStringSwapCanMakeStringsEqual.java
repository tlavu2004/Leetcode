class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int firstIndexDifference = 0, secondIndexDifference = 0;
        int numberOfDifferences = 0;

        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++numberOfDifferences;
                if (numberOfDifferences > 2) {
                    return false;
                } else if (numberOfDifferences == 1) {
                    firstIndexDifference = i;
                } else {
                    secondIndexDifference = i;
                }
            }
        }
        return (
            s1.charAt(firstIndexDifference) == s2.charAt(secondIndexDifference) &&
            s1.charAt(secondIndexDifference) == s2.charAt(firstIndexDifference)
        );
    }
}

public class CheckIfOneStringSwapCanMakeStringsEqual {
    public static void main(String[] args) {
        String s1 = "bank", s2 = "kanb";

        Solution solution = new Solution();
        boolean result = solution.areAlmostEqual(s1, s2);

        System.out.println(result);
    }
}