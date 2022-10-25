// Problem Link : https://leetcode.com/problems/sliding-window-maximum/
// Time complexity : O(N)
// Space Complexity : O(K)
#include<bits/stdc++.h>
using namespace std;

vector < int > maxSlidingWindow(vector < int > & nums, int k) {
  deque < int > dq;
  vector < int > ans;
  for (int i = 0; i < nums.size(); i++) {
    if (!dq.empty() && dq.front() == i - k) dq.pop_front();

    while (!dq.empty() && nums[dq.back()] < nums[i])
      dq.pop_back();

    dq.push_back(i);
    if (i >= k - 1) ans.push_back(nums[dq.front()]);
  }
  return ans;
}
int main() {
  int i, j, n, k , x;
  cin>>k>>n;
  vector < int > arr (n);
  for(int i=0;i<n;i++){
    cin>>arr[i];
  }
  vector < int > ans;
  ans = maxSlidingWindow(arr, k);
  cout << "Maximum element in every " << k << " window " << endl;
  for (i = 0; i < ans.size(); i++)
    cout << ans[i] << " ";
  return 0;
}