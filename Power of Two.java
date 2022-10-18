//Problem link: https://leetcode.com/problems/power-of-two/

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 1)
            return true;
        if(n <= 0 || n%2 != 0)
            return false;
        
        // Using Recursion
        return isPowerOfTwo(n>>1);
        
        // Without using Recursion
        // double k = Math.log(n)/Math.log(2);
        // return Math.floor(k) == k;
    }
}
