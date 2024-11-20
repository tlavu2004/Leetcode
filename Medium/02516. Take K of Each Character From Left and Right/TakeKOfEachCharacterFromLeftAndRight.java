import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    public int takeCharacters(String s, int k) {
        Map<Character, Integer> charactersHashMap = new HashMap<>();
        Map<Character, Integer> remainingCharactersHashMap = new HashMap<>();
        for (char character : s.toCharArray()) {
            remainingCharactersHashMap.put(character, remainingCharactersHashMap.getOrDefault(character, 0) + 1);
        }

        Set<Character> characterKeySet = remainingCharactersHashMap.keySet();
        for (Character character : characterKeySet) {
            if (!((remainingCharactersHashMap.containsKey('a') && remainingCharactersHashMap.containsKey('b') &&
            remainingCharactersHashMap.containsKey('c')) || k == 0) || remainingCharactersHashMap.get(character) - k < 0) {
                return -1;
            } else {
                remainingCharactersHashMap.put(character, remainingCharactersHashMap.get(character) - k);
            }
        }

        int maximumSubarrayLength = 0, left = 0;
        for (int right = 0; right < s.length(); ++right) {
            charactersHashMap.put(s.charAt(right), charactersHashMap.getOrDefault(s.charAt(right), 0) + 1);
            while (left <= right && charactersHashMap.get(s.charAt(right)) > remainingCharactersHashMap.get(s.charAt(right))) {
                charactersHashMap.put(s.charAt(left), charactersHashMap.get(s.charAt(left)) - 1);
                ++left;
            }
            maximumSubarrayLength = Math.max(maximumSubarrayLength, right - left + 1);
        }

        return s.length() - maximumSubarrayLength;
    }
}

public class TakeKOfEachCharacterFromLeftAndRight {
    public static void main(String[] args) {
        String s = "aabaaaacaabc";
        int k = 2;

        Solution solution = new Solution();
        int result = solution.takeCharacters(s, k);

        System.out.print(result);
    }
}