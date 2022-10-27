#include <iostream>
using namespace std;
const int m = 1e7 + 10;
int hsh[m];  //  Global arrays are always initialised to 0

/* Given an array of n integers. given q queries, in each query given a
 number x, print count of that number in the array.(queries == testcases)

 Constraints:
 1 <= t <= 10^5
 1 <= n <= 10^5
 1 <= a[i] <= 10^7

*/
int main()
{
    int n;
    cin >> n;
    int a[n];
    for (int i = 0; i < n; i++){
        cin >> a[i];
    }

   // Using Hashingggg............
   //Time complexity: O(n) + O(t) == O(n)

    for(int i=0; i<n; i++){
    hsh[a[i]]++;
    }

    int t;
    cin >> t;
    while (t--)
    {
        int x;
        cin >> x;
        cout << hsh[x] << endl;
    }

    return 0;
}
