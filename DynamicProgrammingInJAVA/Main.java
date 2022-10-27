package DynamicProgrammingInJAVA;

public class Main {
    public static void main(String[] args) {
        int[] wt = {2, 5, 7, 9};
        int[] val = {2, 6, 7, 8};
        int capacity = 15;
        int size = wt.length;

        System.out.println(recursiveKnapsack(wt, val, capacity, size));
    }

    // Knapsack Recursive
    static int recursiveKnapsack(int[] wt, int[] val, int capacity, int n) {
        // base case
        if (n == 0 || capacity == 0) {
            return 0;
        }

        int weight = wt[n - 1]; // traversing from the back

        // choice diagram
        if (weight <= capacity) {
            return Math.max(val[n - 1] + recursiveKnapsack(wt, val, capacity - weight, n - 1), recursiveKnapsack(wt, val, capacity, n - 1));
        } else {
            return recursiveKnapsack(wt, val, capacity, n - 1);
        }
    }
}
