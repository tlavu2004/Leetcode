import java.util.Arrays;

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int freeDays = 0, latestMeetingEnd = 0;

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            if (start > latestMeetingEnd + 1) {
                freeDays += start - latestMeetingEnd - 1;
            }

            latestMeetingEnd = Math.max(latestMeetingEnd, end);
        }

        freeDays += days - latestMeetingEnd;

        return freeDays;
    }
}

public class CountDaysWithoutMeetings {
    public static void main(String[] args) {
        int days = 10;
        int[][] meetings = {{5, 7}, {1, 3}, {9, 10}};
        
        Solution sol = new Solution();
        int result = sol.countDays(days, meetings);

        System.out.println(result);
    }
}