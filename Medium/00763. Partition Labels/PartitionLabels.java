import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }

        List<Integer> partitions = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastOccurrence.get(s.charAt(i)));
            if (i == end) {
                partitions.add(end - start + 1);
                start = end + 1;
            }
        }

        return partitions;
    }
}

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";

        Solution solution = new Solution();
        List<Integer> result = solution.partitionLabels(s);

        StringBuilder resultStringBuilder = new StringBuilder();
        resultStringBuilder.append("[");
        for (int i = 0; i < result.size(); ++i) {
            resultStringBuilder.append(result.get(i)).append(i < result.size() - 1 ? ", " : "].");
        }

        System.out.println(resultStringBuilder.toString()); 
    }
}