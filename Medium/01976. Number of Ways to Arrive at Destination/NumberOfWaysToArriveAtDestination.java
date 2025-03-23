import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int src = road[0], dest = road[1], time = road[2];
            graph.get(src).add(new int[]{dest, time});
            graph.get(dest).add(new int[]{src, time});
        }

        long[] distances = new long[n];
        long[] numberOfWays = new long[n];
        Arrays.fill(distances, Long.MAX_VALUE);
        distances[0] = 0;
        numberOfWays[0] = 1;

        // {distance, node}
        PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );
        priorityQueue.offer(new long[]{0, 0});

        // This loop explores the graph using Dijkstra's algorithm:
        // 1. Poll the node with the shortest distance from the priority queue.
        // 2. If the distance of the node is greater than the distance in the priority queue, skip it.
        // 3. For each neighbor of the node, calculate the new distance and the number of ways to reach the neighbor.
        // 4. If the new distance is less than the distance of the neighbor, update the distance and the number of ways.
        // 5. If the new distance is equal to the distance of the neighbor, update the number of ways.
        while (!priorityQueue.isEmpty()) {
            long[] current = priorityQueue.poll();
            int node = (int) current[1];
            long distance = current[0];

            if (distances[node] < distance) {
                continue;
            }

            for (int[] next : graph.get(node)) {
                int nextNode = next[0], time = next[1];
                long newDistance = distance + time;

                if (newDistance < distances[nextNode]) {
                    distances[nextNode] = newDistance;
                    numberOfWays[nextNode] = numberOfWays[node];
                    priorityQueue.offer(new long[]{newDistance, nextNode});
                } else if (newDistance == distances[nextNode]) {
                    numberOfWays[nextNode] = (numberOfWays[nextNode] + numberOfWays[node]) % MOD;
                }
            }
        }

        return (int) numberOfWays[n - 1];
    }
}

public class NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {
            {0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3},
            {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}
        };

        Solution sol = new Solution();
        int result = sol.countPaths(n, roads);

        System.out.println(result);
    }
}