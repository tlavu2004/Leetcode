class Solution {
    public int maximumSum(int[] nums) {
        int maximumSum = -1;
        // Array to map digit sums to the largest element with that sum (82 to cover all possible sums from 0 to 81)
        int[] resultMapping = new int[82];
        
        for (int num : nums) {
            int digitSum = 0;
            for (int currentNum = num; currentNum != 0; currentNum /= 10) {
                int currentDigit = currentNum % 10;
                digitSum += currentDigit;
            }

            if (resultMapping[digitSum] > 0) {
                maximumSum = Math.max(maximumSum, resultMapping[digitSum] + num);
            }

            resultMapping[digitSum] = Math.max(resultMapping[digitSum], num);
        }

        return maximumSum;
    }
}

public class MaxSumOfAPairWithEqualSumOfDigits {
    public static void main(String[] args) {
        int[] nums = {18, 43, 36, 13, 7};

        Solution solution = new Solution();
        int result = solution.maximumSum(nums);

        System.out.print(result);
    }
}