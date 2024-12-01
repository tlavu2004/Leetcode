import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int arrLength = arr.length;
        for (int i = 0; i < arrLength; ++i) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arrLength; ++i) {
            if (map.containsKey(arr[i] * 2) && map.get(arr[i] * 2) != i) {
                return true;
            }
        }
        return false;
    }
}

public class CheckIfNAndItsDoubleExist {
    public static void main(String[] args) {
        int[] arr = {10, 2, 5, 3};

        Solution solution = new Solution();
        boolean result = solution.checkIfExist(arr);

        System.out.println(result);
    }
}