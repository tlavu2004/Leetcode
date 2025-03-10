import java.util.HashMap;
import java.util.Map;

class Solution {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private long substringsLengthAtLeastK(String word, int k) {
        int wordLength = word.length(), left = 0, consonants = 0;
        long countOfSubstrings = 0;
        Map<Character, Integer> vowelMap = new HashMap<>();

        for (int right = 0; right < wordLength; ++right) {
            char currentChar = word.charAt(right);
            if (isVowel(currentChar)) {
                vowelMap.put(
                    currentChar,
                    vowelMap.getOrDefault(
                        currentChar,
                        0
                    ) + 1
                );
            } else {
                ++consonants;
            }

            // vowelMap.size() == number of keys (== number of key-value pairs)
            while (vowelMap.size() == 5 && consonants >= k) {
                // Count beyond till the end of the word.
                countOfSubstrings += wordLength - right;

                char leftChar = word.charAt(left);
                if (isVowel(leftChar)) {
                    vowelMap.put(leftChar, vowelMap.get(leftChar) - 1);
                    if (vowelMap.get(leftChar) == 0) {
                        vowelMap.remove(leftChar);
                    }
                } else {
                    --consonants;
                }
                ++left;
            }
        }

        return countOfSubstrings;
    }

    public long countOfSubstrings(String word, int k) {
        return substringsLengthAtLeastK(word, k) - substringsLengthAtLeastK(word, k + 1);
    }
}

public class CountOfSubstringsContainingEveryVowelAndKConsonantsII {
    public static void main(String[] args) {
        String word = "ieaouqqieaouqq";
        int k = 1;

        Solution solution = new Solution();
        long result = solution.countOfSubstrings(word, k);

        System.out.println(result);
    }
}