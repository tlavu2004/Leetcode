import java.util.Arrays;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));

        int itemsLength = items.length;
        int[] maximumBeautyTillItem = new int[itemsLength];
        maximumBeautyTillItem[0] = items[0][1];
        for (int i = 1; i < itemsLength; ++i) {
            maximumBeautyTillItem[i] = Math.max(maximumBeautyTillItem[i - 1], items[i][1]);
        }

        int queriesLength = queries.length;
        int[] result = new int[queriesLength];
        for (int i = 0; i < queriesLength; ++i) {
            result[i] = findMaxBeautyByQuery(items, queries[i], maximumBeautyTillItem);
        }
        return result;
    }

    private int findMaxBeautyByQuery(int[][] items, int query, int[] maximumBeautyTillItem) {        
        int left = 0, right = items.length - 1;
        while (left < right) {
            int middle = left + (right - left + 1) / 2;
            if (items[middle][0] > query) {
                right = middle - 1;
            } else {
                left = middle;
            }
        }

        return (items[left][0] <= query) ? maximumBeautyTillItem[left] : 0;
    }
}

public class MostBeautifulItemForEachQuery {
    public static void main(String[] args) {
        int[][] items = {
            {193, 732}, {781, 962}, {864, 954}, {749, 627}, {136, 746}, 
            {478, 548}, {640, 908}, {210, 799}, {567, 715}, {914, 388}, 
            {487, 853}, {533, 554}, {247, 919}, {958, 150}, {193, 523}, 
            {176, 656}, {395, 469}, {763, 821}, {542, 946}, {701, 676}};
        int[] queries = {
            885, 1445, 1580, 1309, 205, 
            1788, 1214, 1404, 572, 1170, 
            989, 265, 153, 151, 1479, 
            1180, 875, 276, 1584};

        Solution solution = new Solution();
        int[] result = solution.maximumBeauty(items, queries);

        System.out.print("[");
        for (int i = 0; i < result.length; ++i) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            } else {
                System.out.println("].");
            }
        }
    }
}
