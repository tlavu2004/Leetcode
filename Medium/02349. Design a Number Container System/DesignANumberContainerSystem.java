import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

class NumberContainers {
    private Map<Integer, Integer> indexToNumbers;
    private Map<Integer, PriorityQueue<Integer>> numberToIndices;

    public NumberContainers() {
        indexToNumbers = new HashMap<>();
        numberToIndices = new HashMap<>();
    }
    
    public void change(int index, int number) {
        indexToNumbers.put(index, number);
        numberToIndices
            .computeIfAbsent(number, k -> new PriorityQueue<>())
            .add(index);
    }
    
    public int find(int number) {
        if (!numberToIndices.containsKey(number)) {
            return -1;
        }

        PriorityQueue<Integer> minimumHeap = numberToIndices.get(number);
        while (!minimumHeap.isEmpty()) {
            int index = minimumHeap.peek();
            if (indexToNumbers.get(index) == number) {
                return index;
            }
            minimumHeap.poll();
        }

        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */

public class DesignANumberContainerSystem {
    public static void main(String[] args) {
        String activities[] = {
            "NumberContainers",
            "find", "change", "change", "change",
            "change", "find", "change", "find"
        };
        int[][] values = {
            {}, {10}, {2, 10}, {1, 10}, {3, 10},
            {5, 10}, {10}, {1, 20}, {10}
        };
        NumberContainers numberContainers = new NumberContainers();
        int activitiesLength = activities.length;
        Integer[] result = new Integer[activitiesLength];
        
        for (int i = 0; i < activitiesLength; ++i) {
            if (activities[i] == "NumberContainers") {
                // numberContainers = new NumberContainers();
            } else if (activities[i] == "change") {
                numberContainers.change(values[i][0], values[i][1]);
            } else if (activities[i] == "find") {
                result[i] = numberContainers.find(values[i][0]);
            } else {
                result[i] = Integer.MIN_VALUE;
            }
        }

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