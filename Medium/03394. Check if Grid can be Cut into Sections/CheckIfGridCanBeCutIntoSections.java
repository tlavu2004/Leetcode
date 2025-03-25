import java.util.Arrays;

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] xIntervals = new int[rectangles.length][2];
        int[][] yIntervals = new int[rectangles.length][2];

        for (int i = 0; i < rectangles.length; i++) {
            xIntervals[i][0] = rectangles[i][0];
            xIntervals[i][1] = rectangles[i][2];

            yIntervals[i][0] = rectangles[i][1];
            yIntervals[i][1] = rectangles[i][3];
        }

        return checkValidCutsPerDimension(xIntervals) || checkValidCutsPerDimension(yIntervals);
    }

    public boolean checkValidCutsPerDimension(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int sections = 0;
        int maximumEnd = intervals[0][1]; // End of x-axis and y-axis depends on the parameter.

        for (int[] interval : intervals) {
            if (interval[0] >= maximumEnd) {
                ++sections;
            }
            maximumEnd = Math.max(maximumEnd, interval[1]);
        }

        return sections >= 2;
    }
}

public class CheckIfGridCanBeCutIntoSections {
    public static void main(String[] args) {
        int n = 5;
        int[][] rectangles = {
            {1, 0, 5, 2},
            {0, 2, 2, 4},
            {3, 2, 5, 3}, 
            {0, 4, 4, 5}
        };

        Solution sol = new Solution();
        boolean result = sol.checkValidCuts(n, rectangles);

        System.out.println(result);
    }
}