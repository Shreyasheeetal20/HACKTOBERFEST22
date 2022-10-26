/*
Approach for "Maximum Sum Contiguous Subarray Question" using "Kadane Algorithm"
Time Complexity : O(N)
Space Complexity : O(1)
*/

#include<bits/stdc++.h>
using namespace std;
int max_SubArraySum(int nums[], int size)
{
    int currentMax = INT_MIN, tempMax = 0;

    for (int i = 0; i < size; i++)
    {
        tempMax = tempMax + nums[i];
        if (currentMax < tempMax)
            currentMax = tempMax;

        if (tempMax < 0)
            tempMax = 0;
    }
    return currentMax;
}
int main() {
   int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
   int n = sizeof(nums)/sizeof(nums[0]);

   int max_sum = max_SubArraySum(nums, n);
   cout << "Maximum Subarray Sum is " << max_sum;
   return 0;
}
