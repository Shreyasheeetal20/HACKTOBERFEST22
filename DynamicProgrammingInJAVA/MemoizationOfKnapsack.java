package DynamicProgrammingInJAVA;

import java.util.Arrays;

public class MemoizationOfKnapsack {
    public static void main(String[] args) {
        int[] wt = {2, 5, 7, 9};
        int[] val = {2, 6, 7, 8};
        int capacity = 15;

        System.out.println(memoizedKnapsack(wt, val, capacity));
    }

    static int memoizedKnapsack(int[] wt, int[] val, int capacity) {
        int size = wt.length;
        int[][] dp = new int[size + 1][capacity + 1];

        // initializing the 2D array with -1
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        int none = memoization(wt, val, capacity, size, dp);    // this can also be returned

        return dp[size][capacity];
    }

    static int memoization(int[] wt, int[] val, int capacity, int size, int[][] dp) {
        // make the matrix for only those variables that are changing in a recursive call
        // here, changing variables are capacity and size

        if (size == 0 || capacity == 0) {
            return 0;
        }

        // if there is an existing value in dp[][], then use it
        if (dp[size][capacity] != -1) {
            return dp[size][capacity];
        }

        int weight = wt[size - 1]; // traversing from the back

        // choice diagram
        if (weight <= capacity) {
            return dp[size][capacity] = Math.max(val[size - 1] + memoization(wt, val, capacity - weight, size - 1, dp),
                    memoization(wt, val, capacity, size - 1, dp));
        } else {
            return dp[size][capacity] = memoization(wt, val, capacity, size - 1, dp);
        }
    }
}
