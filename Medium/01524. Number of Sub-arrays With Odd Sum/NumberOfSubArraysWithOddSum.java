class Solution {
    public int numOfSubarrays(int[] arr) {
        long oddSumSubarrayCount = 0, prefixSum = 0;
        for (int element : arr) {
            prefixSum += element;
            oddSumSubarrayCount += (prefixSum % 2);
        }

        oddSumSubarrayCount += (arr.length - oddSumSubarrayCount) * oddSumSubarrayCount;
        return (int)(oddSumSubarrayCount % 1_000_000_007);
    }
}

public class NumberOfSubArraysWithOddSum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};

        Solution solution = new Solution();
        int result = solution.numOfSubarrays(arr);
        
        System.out.println(result);
    }
}