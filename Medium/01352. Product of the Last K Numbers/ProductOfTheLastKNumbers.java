import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    List<Integer> listOfProducts;

    public ProductOfNumbers() {
        listOfProducts = new ArrayList<>();
        listOfProducts.add(1);
    }
    
    public void add(int num) {
        if (num == 0) {
            listOfProducts = new ArrayList<>();
            listOfProducts.add(1);
        } else {
            listOfProducts.add(listOfProducts.get(listOfProducts.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        if (k >= listOfProducts.size()) {
            return 0;
        }

        return listOfProducts.get(listOfProducts.size() - 1) / listOfProducts.get(listOfProducts.size() - 1 - k);
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
        String activities[] = {
            "ProductOfNumbers",
            "add", "add", "add", "add", "add",
            "getProduct", "getProduct", "getProduct", "add", "getProduct"
        };
        int[][] values = {
            {}, {3}, {0}, {2}, {5}, {4},
                {2}, {3}, {4}, {8}, {2}
        };
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        int activitiesLength = activities.length;
        Integer[] result = new Integer[activitiesLength];
        
        for (int i = 0; i < activitiesLength; ++i) {
            if (activities[i] == "ProductOfNumbers") {
                // productOfNumbers = new ProductOfNumbers();
            } else if (activities[i] == "add") {
                productOfNumbers.add(values[i][0]);
            } else if (activities[i] == "getProduct") {
                result[i] = productOfNumbers.getProduct(values[i][0]);
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