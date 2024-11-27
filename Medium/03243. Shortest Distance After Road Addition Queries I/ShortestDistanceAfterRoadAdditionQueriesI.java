import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adjacentLists = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adjacentLists.add(new ArrayList<>());
            adjacentLists.get(i).add(i + 1); // Ignore (n - 1: n).
        }

        List<Integer> resultList = new ArrayList<>();
        for (int[] query : queries) {
            adjacentLists.get(query[0]).add(query[1]);
            resultList.add(shortestPath(n, adjacentLists));
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    private int shortestPath(int n, List<List<Integer>> adjacentLists) {
        Queue<Integer[]> queue = new LinkedList<>();
        // { No. of current node, Current shortest path }.
        // Always start at 0.
        queue.offer(new Integer[] {0, 0}); 
        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        while (!queue.isEmpty()) {
            Integer[] currentQueueElement = queue.poll();
            Integer currentNode = currentQueueElement[0];
            Integer currentShortestPath = currentQueueElement[1];

            if (currentNode == n - 1) {
                return currentShortestPath;
            }

            for (Integer neighbor : adjacentLists.get(currentNode)) {
                if (!visited.contains(neighbor)) {
                    queue.offer(new Integer[] {neighbor, currentShortestPath + 1});
                    visited.add(neighbor);
                }
            }
        }

        // Not using, just ignore the complier.
        return -1;
    }
}

public class ShortestDistanceAfterRoadAdditionQueriesI {
    public static void main(String[] args) {
        int n = 5;
        int[][] queries = {{2, 4}, {0, 2}, {0, 4}};

        Solution solution = new Solution();
        int[] result = solution.shortestDistanceAfterQueries(n, queries);

        System.out.print("[");
        for (int i = 0; i < result.length; ++i) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            } else {
                System.out.print("].");
            }
        }
    }
}