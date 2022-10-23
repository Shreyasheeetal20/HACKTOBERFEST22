// CALCULATE THE VALUE OF nCr EFFICIENTLY
// using Dynamic Programming

#include <bits/stdc++.h>
using namespace std;
#define int long long

// You can change N according to your needs (take N<=1e5)
int N = 1000;
vector<vector<int>> dp(N, vector<int>(N, 0));
int ncr(int n, int r)
{
	if (n == r) // if both are same
	{
		return dp[n][r] = 1;
	}
	if (r == 0)
	{
		return dp[n][r] = 1;
	}
	if (r == 1)
	{
		return dp[n][r] = n;
	}
	if (dp[n][r])
	{
		return dp[n][r]; // Using Subproblem Result
	}
	return dp[n][r] = ncr(n - 1, r) + ncr(n - 1, r - 1);
}

signed main()
{
	int n = 4;
	int r = 2;
	// make sure n >= r
	cout << ncr(n, r) << endl;
}
// Code Contributed by: Sushrut Lachure (Sushrut22)