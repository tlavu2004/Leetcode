class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i].charAt(i) == '0') {
                result.append('1');
            } else {
                result.append('0');
            }
        }

        return result.toString();
    }
}

public class FindUniqueBinaryString {
    public static void main(String[] args) {
        String[] nums = {"01", "10"};

        Solution solution = new Solution();
        String result = solution.findDifferentBinaryString(nums);

        System.out.print(result);
    }
}