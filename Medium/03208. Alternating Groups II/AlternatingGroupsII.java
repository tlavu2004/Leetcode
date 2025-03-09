class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int circleLength = colors.length;
        int alternatingGroups = 0, left = 0;

        for (int right = 0; right < circleLength + k - 1; ++right) {
            if (
                right > 0 && 
                colors[right % circleLength] == colors[(right + 1) % circleLength]
            ) {
                left = right;
            }

            if (right - left + 1 >= k) {
                ++alternatingGroups;
            }
        }

        return alternatingGroups;
    }
}

public class AlternatingGroupsII {
    public static void main(String[] args) {
        int[] colors = {0, 1, 0, 1, 0};
        int k = 3;
        
        Solution solution = new Solution();
        int result = solution.numberOfAlternatingGroups(colors, k);

        System.out.println(result);
    }
}