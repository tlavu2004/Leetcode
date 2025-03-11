class Solution {
    public int numberOfSubstrings(String s) {
        int[] charactersLastSeenIndex = {-1, -1, -1};
        int countOfSubstrings = 0;

        for (int i = 0; i < s.length(); ++i) {
            charactersLastSeenIndex[s.charAt(i) - 'a'] = i;
            if (
                charactersLastSeenIndex[0] != -1 &&
                charactersLastSeenIndex[1] != -1 &&
                charactersLastSeenIndex[2] != -1
            ) {
                countOfSubstrings += 1 + 
                    Math.min(charactersLastSeenIndex[0],
                        Math.min(
                            charactersLastSeenIndex[1],
                            charactersLastSeenIndex[2]
                        )
                    );
            }
        }

        return countOfSubstrings;
    }
}

public class NumberOfSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        String s = "abcabc";

        Solution solution = new Solution();
        int result = solution.numberOfSubstrings(s);

        System.out.println(result);
    }
}