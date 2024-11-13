class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length, nums2Length = nums2.length;
        int i = 0, j = 0, middleValue1 = 0, middleValue2 = 0;

        for (int count = 0; count <= (nums1Length + nums2Length) / 2; ++count) {
            middleValue2 = middleValue1;
            
            if (i < nums1Length && j < nums2Length) {
                if (nums1[i] < nums2[j]) {
                    middleValue1 = nums1[i++]; 
                } else {
                    middleValue1 = nums2[j++]; 
                }
            } else if (i < nums1Length) {
                middleValue1 = nums1[i++];
            } else {
                middleValue1 = nums2[j++]; 
            }
        }

        return ((nums1Length + nums2Length) % 2 == 1) ? (double)middleValue1 : (double)(middleValue1 + middleValue2) / 2.0;
    }
}

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2}, nums2 = {3, 4};

        Solution solution = new Solution();
        double result = solution.findMedianSortedArrays(nums1, nums2);

        System.out.println(result);
    }
}
