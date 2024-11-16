class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int arrayLength = arr.length;
        int left = 0, right = arrayLength - 1;
        while (left + 1 < arrayLength && arr[left] <= arr[left + 1]) {
            ++left;
        }

        if (left == arrayLength - 1) {
            return 0;
        }

        while (right > 0 && arr[right - 1] <= arr[right]) {
            --right;
        }

        int result = Math.min(arrayLength - 1 - left, right);

        int i = 0, j = right;
        while (i <= left && j < arrayLength) {
            if (arr[i] <= arr[j]) {
                // Actually it's j - i + 1 - 2 (remove 2 boundaries).
                result = Math.min(result, j - i - 1); 
                ++i;
            } else {
                ++j;
            }
        }

        return result;
    }
}

public class ShortestSubarrayToBeRemovedToMakeArraySorted {
    public static void main(String[] args) {
        int[] arr = {6, 3, 10, 11, 15, 20, 13, 3, 18, 12};

        Solution solution = new Solution();
        int result = solution.findLengthOfShortestSubarray(arr);

        System.out.println(result);
    }
}