// Problem Link: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

class Solution {
    public int countNegatives(int[][] grid) {
        int i = 0;
        int j = grid[0].length - 1;
        int m = grid.length;
        int ans = 0;
        while (i < m && j >= 0) {
            if (grid[i][j] < 0) {
                ans += m - i ;
                j--;
            } 
            else
                i++;
        }
        return ans;
    }
}
