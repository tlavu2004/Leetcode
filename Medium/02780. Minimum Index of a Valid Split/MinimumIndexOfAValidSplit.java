import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int dominantElement = findDominantElement(nums);
        if (dominantElement == -1) {
            return -1;
        }

        int leftDominantElementCount = 0, totalDominantElementCount = 0;
        for (int num : nums) {
            if (num == dominantElement) {
                ++totalDominantElementCount;
            }
        }

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == dominantElement) {
                ++leftDominantElementCount;
            }

            if (
                leftDominantElementCount > (i + 1) / 2 &&
                (totalDominantElementCount - leftDominantElementCount) > (nums.size() - i - 1) / 2
            ) {
                return i;
            }
        }

        return -1;
    }

    // Boyer-Moore Majority Vote algorithm
    private int findDominantElement(List<Integer> nums) {
        int candidate = -1, voteCount = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            if (voteCount == 0) {
                candidate = nums.get(i);
                voteCount = 1;
            } else if (nums.get(i) == candidate) {
                ++voteCount;
            } else {
                --voteCount;
            }
        }

        int candidateTotalCount = 0;
        for (int num : nums) {
            if (num == candidate) {
                ++candidateTotalCount;
            }
        }

        return (candidateTotalCount > nums.size() / 2) ? candidate : -1;
    }
}

public class MinimumIndexOfAValidSplit {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1); nums.add(2);
        nums.add(2); nums.add(2);

        Solution solution = new Solution();
        int result = solution.minimumIndex(nums);

        System.out.println(result);
    }
}