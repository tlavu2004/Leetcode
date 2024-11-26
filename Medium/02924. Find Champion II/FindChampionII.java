import java.util.Arrays;

class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean[] isUndefeated = new boolean[n];
        Arrays.fill(isUndefeated, true);

        for (int[] edge : edges) {
            int loser = edge[1];
            isUndefeated[loser] = false;
        }

        int champion = -1, championsCount = 0;

        for (int team = 0; team < n; ++team) {
            if (isUndefeated[team]) {
                champion = team;
                ++championsCount;
            }
        }

        return championsCount == 1 ? champion : -1;
    }
}

public class FindChampionII {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}};

        Solution solution = new Solution();
        int result = solution.findChampion(n, edges);

        System.out.print(result);
    }
}