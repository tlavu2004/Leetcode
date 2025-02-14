import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    private List<Integer> prefixProduct;

    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
        prefixProduct.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            prefixProduct.clear();
            prefixProduct.add(1);
        } else {
            prefixProduct.add(prefixProduct.get(prefixProduct.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        if (k >= prefixProduct.size()) {
            return 0;
        }
        return prefixProduct.get(prefixProduct.size() - 1) / prefixProduct.get(prefixProduct.size() - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */

 public class ProductOfTheLastKNumbers {
    public static void main(String[] args) {
        String[] activities = {
            "ProductOfNumbers", "add", "add", "add", "add", "add",
            "getProduct", "getProduct", "getProduct", "add", "getProduct"
        };
        int[][] values = {
            {}, {3}, {0}, {2}, {5}, {4},
            {2}, {3}, {4}, {8}, {2}
        };

        executeOperations(activities, values);
    }

    private static void executeOperations(String[] activities, int[][] values) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < activities.length; ++i) {
            switch (activities[i]) {
                case "add":
                    productOfNumbers.add(values[i][0]);
                    result.add(null);
                    break;
                case "getProduct":
                    result.add(productOfNumbers.getProduct(values[i][0]));
                    break;
                default:
                    result.add(null);
                    break;
            }
        }

        System.out.println(result);
    }
}