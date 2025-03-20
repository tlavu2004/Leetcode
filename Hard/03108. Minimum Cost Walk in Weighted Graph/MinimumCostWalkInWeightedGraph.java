import java.util.Arrays;

/* TLE at test 546/548
class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] parent = new int[n];
        int[] minimumPathCost = new int[n];
        Arrays.fill(minimumPathCost, -1);

        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int source = edge[0], target = edge[1], weight = edge[2];
            int sourceRoot = findRoot(parent, source);
            int targetRoot = findRoot(parent, target);

            minimumPathCost[targetRoot] &= weight;

            if (sourceRoot != targetRoot) {
                minimumPathCost[targetRoot] &= minimumPathCost[sourceRoot];
                parent[sourceRoot] = targetRoot;
            }
        }

        int[] result = new int[query.length];
        for (int i = 0; i < query.length; ++i) {
            int start = query[i][0], end = query[i][1];

            if (start == end) {
                result[i] = 0;
            } else if (findRoot(parent, start) != findRoot(parent, end)) {
                result[i] = -1;
            } else {
                result[i] = minimumPathCost[findRoot(parent, start)];
            }
        }

        return result;
    }

    private int findRoot(int[] parent, int currentNode) {
        if (parent[currentNode] != currentNode) {
            return findRoot(parent, parent[currentNode]);
        }

        return parent[currentNode];
    }
}
*/


class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] parent = new int[n];
        int[] rank = new int[n]; // Thêm rank để tối ưu Union
        int[] minimumPathCost = new int[n];
        Arrays.fill(minimumPathCost, -1);

        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            int source = edge[0], target = edge[1], weight = edge[2];
            union(parent, rank, minimumPathCost, source, target, weight);
        }

        int[] result = new int[query.length];
        for (int i = 0; i < query.length; ++i) {
            int start = query[i][0], end = query[i][1];

            int rootStart = findRoot(parent, start);
            int rootEnd = findRoot(parent, end);

            if (start == end) {
                result[i] = 0;
            } else if (rootStart != rootEnd) {
                result[i] = -1;
            } else {
                result[i] = minimumPathCost[rootStart];
            }
        }

        return result;
    }

    private int findRoot(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = findRoot(parent, parent[node]); // Path compression
        }
        return parent[node];
    }

    private void union(int[] parent, int[] rank, int[] minimumPathCost, int a, int b, int weight) {
        int rootA = findRoot(parent, a);
        int rootB = findRoot(parent, b);

        if (rootA != rootB) {
            if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
                minimumPathCost[rootA] &= (minimumPathCost[rootB] == -1 ? weight : minimumPathCost[rootB]);
            } else if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
                minimumPathCost[rootB] &= (minimumPathCost[rootA] == -1 ? weight : minimumPathCost[rootA]);
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
                minimumPathCost[rootA] &= (minimumPathCost[rootB] == -1 ? weight : minimumPathCost[rootB]);
            }
        }
        minimumPathCost[rootA] &= weight;
        minimumPathCost[rootB] &= weight;
    }
}

public class MinimumCostWalkInWeightedGraph {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1, 7}, {1, 3, 7}, {1, 2, 1}};
        int[][] query = {{0, 3}, {3, 4}};

        Solution solution = new Solution();
        int[] result = solution.minimumCost(n, edges, query);

        StringBuilder resultStringBuilder = new StringBuilder();
        resultStringBuilder.append("[");
        for (int i = 0; i < result.length; ++i) {
            resultStringBuilder.append(result[i]).append(i < result.length - 1 ? ", " : "].");
        }

        System.out.println(resultStringBuilder.toString());
    }
}