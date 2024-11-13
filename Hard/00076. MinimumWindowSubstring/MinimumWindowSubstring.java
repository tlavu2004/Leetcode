import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> characterCount = new HashMap<>();
        for (char ch : t.toCharArray()) {
            characterCount.put(ch, characterCount.getOrDefault(ch, 0) + 1);
        }

        int targetCharactersRemaining = t.length(), startIndex = 0;
        int[] minimumWindow = {0, Integer.MAX_VALUE};

        for (int endIndex = 0; endIndex < s.length(); ++endIndex) {
            char ch = s.charAt(endIndex);
            if (characterCount.containsKey(ch) && characterCount.get(ch) > 0) {
                --targetCharactersRemaining;
            }
            characterCount.put(ch, characterCount.getOrDefault(ch, 0) - 1);
        
            if (targetCharactersRemaining == 0) {
                while(true) {
                    char charAtStart = s.charAt(startIndex);
                    if (characterCount.containsKey(charAtStart) && characterCount.get(charAtStart) == 0) {
                        break;
                    }
                    characterCount.put(charAtStart, characterCount.getOrDefault(charAtStart, 0) + 1);
                    ++startIndex;
                }

                if (endIndex - startIndex < minimumWindow[1] - minimumWindow[0]) {
                    minimumWindow[0] = startIndex;
                    minimumWindow[1] = endIndex;
                }

                characterCount.put(s.charAt(startIndex), characterCount.getOrDefault(s.charAt(startIndex), 0) + 1);
                ++startIndex;
                ++targetCharactersRemaining;
            }
        }

        return minimumWindow[1] >= s.length() ? "" : s.substring(minimumWindow[0], minimumWindow[1] + 1);
    }
}

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";

        Solution solution = new Solution();
        String result = solution.minWindow(s, t);

        System.out.println(result);
    }
}
