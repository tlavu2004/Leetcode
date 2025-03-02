import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int nums1Length = nums1.length, nums2Length = nums2.length;
        int pointer1 = 0, pointer2 = 0;
        List<int[]> resultMergedList = new ArrayList<>();

        while (pointer1 < nums1Length || pointer2 < nums2Length) {
            if (pointer1 < nums1Length && (pointer2 >= nums2Length || nums1[pointer1][0] < nums2[pointer2][0])) {
                resultMergedList.add(nums1[pointer1++]);
            } else if (pointer2 < nums2Length && (pointer1 >= nums1Length || nums1[pointer1][0] > nums2[pointer2][0])) {
                resultMergedList.add(nums2[pointer2++]);
            } else {
                resultMergedList.add(new int[]{ nums1[pointer1][0], nums1[pointer1][1] + nums2[pointer2][1] });
                ++pointer1;
                ++pointer2;
            }
        }

/*
    - resultMergedList.toArray(...) :The toArray(T[] a) method of ArrayList helps convert a List<int[]> into a two-dimensional array int[][].
    - new int[0][]: 
        + The argument new int[0][] specifies the type of the target array (a 2D array int[][]).
        + If the list has more than 0 elements, Java will automatically allocate an array large enough to contain all the elements.
        + If the list is empty, it will return new int[0][], which is an empty int[][] array.
*/
        return resultMergedList.toArray(new int[0][]);
    }
}

public class MergeTwo2DArraysBySummingValues {
    public static void main(String[] args) {
        int[][] nums1 = {{1,2},{2,3},{4,5}};
        int[][] nums2 = {{1,4},{3,2},{4,1}};
        
        Solution solution = new Solution();
        int[][] result = solution.mergeArrays(nums1, nums2);

        StringBuilder resultStringBuilder = new StringBuilder("[\n");
        for (int[] row : result) {
            resultStringBuilder.append("  [");
            resultStringBuilder.append(Arrays.stream(row)
                    .mapToObj(c -> "\"" + c + "\"")
                    .collect(Collectors.joining(", ")));
            resultStringBuilder.append("],\n");
        }
        resultStringBuilder.setLength(resultStringBuilder.length() - 2);
        resultStringBuilder.append("\n].");

        System.out.println(resultStringBuilder.toString());
    }
}