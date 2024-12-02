class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int wordsLength = words.length;

        for (int i = 0; i < wordsLength; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }

        return -1;
    }
}

public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
    public static void main(String[] args) {
        String sentence = "i love eating burger", searchWord = "burg";

        Solution solution = new Solution();
        int result = solution.isPrefixOfWord(sentence, searchWord);
        
        System.out.print(result);
    }
}