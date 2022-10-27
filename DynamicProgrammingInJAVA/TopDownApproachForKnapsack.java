package DynamicProgrammingInJAVA;

public class TopDownApproachForKnapsack {
    public static void main(String[] args) {
        int[] wt = {2, 5, 7, 9};
        int[] val = {2, 6, 7, 8};
        int capacity = 15;

        System.out.println(topDownKnapsack(wt, val, capacity, wt.length));
    }

    static int topDownKnapsack(int[] wt, int[] val, int capacity, int size) {
        int[][] dp = new int[size + 1][capacity + 1];

        // Base Condition of Recursive Call becomes the Initialization of TDA
        for (int col = 0; col < capacity; col++) { // top row is now all 0
            dp[0][col] = 0;
        }
        for (int row = 0; row < size; row++) { // top leftmost column is now all 0
            dp[row][0] = 0;
        }

        // running for-loops for the uninitialized portion of dp[][] matrix
        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                // choice diagram : replace 'size' with 'i' and 'capacity' with 'j'
                int weight = wt[i - 1];

                if (weight <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - weight], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // final answer
        return dp[size][capacity];
    }
}
