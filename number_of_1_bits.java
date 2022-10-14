public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int c= 0, rsbm;
        while (n != 0)
        {
            rsbm= n & -n;
            n-= rsbm;
            c++;
        }
        return c;
    }
    // [Watch video on Brian Kernighan’s Algorithm @ Pepcoding]
}
