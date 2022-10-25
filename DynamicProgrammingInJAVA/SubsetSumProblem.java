package DynamicProgrammingInJAVA;

/*

Given a set of non-negative integers, and a value 'sum'. Determine if there is a subset of the given set with sum of
all elements equal to the given 'sum'.

*/

public class SubsetSumProblem {
    public static void main(String[] args) {
        int[] arr = {3, 7, 9, 10, 14};
        int sum = 20;

        System.out.println(subsetSum(arr, sum, arr.length));
    }

    static boolean subsetSum(int[] arr, int sum, int n) {
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // initialization

        // given an array of any size, we can always have an empty array [{}] as its subset, whose sum of all terms is 0
        // therefore, leftmost column should contain 'true'
        for (int row = 0; row < n + 1; row++) {     // leftmost column is now all true
            dp[row][0] = true;
        }

        // given an empty array [{}], we can never have a subset whose sum is an integer other than 0
        // therefore, topmost row(other than dp[0][0]) should contain 'false'
        for (int col = 1; col < sum + 1; col++) {   // topmost row is now all false
            dp[0][col] = false;
        }

        // code
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int currentElement = arr[i - 1];

                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - currentElement] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // final answer
        return dp[n][sum];
    }
}
