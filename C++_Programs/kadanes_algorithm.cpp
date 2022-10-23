#include <bits/stdc++.h>
using namespace std;
void solve()
{
    int n;
    cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; i++){
        cin >> a[i];
    }
    int localMax = 0;
    int globalMax = INT_MIN;
    for (int i = 0; i < n; i++){
        localMax = max(a[i], a[i] + localMax);
        if (localMax > globalMax){
            globalMax = localMax;
        }
    }
    cout << globalMax << endl;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    solve();
    return 0;
}