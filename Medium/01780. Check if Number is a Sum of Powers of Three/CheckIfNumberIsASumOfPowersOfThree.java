class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}

public class CheckIfNumberIsASumOfPowersOfThree {
    public static void main(String[] args) {
        int n = 21;

        Solution solution = new Solution();
        boolean result = solution.checkPowersOfThree(n);

        System.out.println(result);
    }
}