import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

class NumberContainers {
    private final Map<Integer, Integer> indexToNumbers;
    private final Map<Integer, PriorityQueue<Integer>> numberToIndices;

    public NumberContainers() {
        indexToNumbers = new HashMap<>();
        numberToIndices = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexToNumbers.containsKey(index)) {
            int oldNumber = indexToNumbers.get(index);
            if (oldNumber != number) {
                numberToIndices.get(oldNumber).remove(index);
                if (numberToIndices.get(oldNumber).isEmpty()) {
                    numberToIndices.remove(oldNumber);
                }
            }
        }
        indexToNumbers.put(index, number);
        numberToIndices.computeIfAbsent(number, k -> new PriorityQueue<>()).add(index);
    }

    public int find(int number) {
        if (!numberToIndices.containsKey(number)) {
            return -1;
        }

        PriorityQueue<Integer> minHeap = numberToIndices.get(number);
        while (!minHeap.isEmpty() && indexToNumbers.get(minHeap.peek()) != number) {
            minHeap.poll();
        }

        return minHeap.isEmpty() ? -1 : minHeap.peek();
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
        String[] activities = {
            "NumberContainers", "find", "change", "change", "change",
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
            switch (activities[i]) {
                case "change":
                    numberContainers.change(values[i][0], values[i][1]);
                    result[i] = null;
                    break;
                case "find":
                    result[i] = numberContainers.find(values[i][0]);
                    break;
                default:
                    result[i] = null; // Đánh dấu vị trí không có giá trị đầu ra
                    break;
            }
        }

        // In kết quả sử dụng StringBuilder để tối ưu I/O
        StringBuilder output = new StringBuilder("[");
        for (int i = 0; i < result.length; ++i) {
            if (result[i] != null) {
                output.append(result[i]);
            } else {
                output.append("null");
            }
            if (i < result.length - 1) {
                output.append(", ");
            }
        }
        output.append("].");
        System.out.println(output);
    }
}