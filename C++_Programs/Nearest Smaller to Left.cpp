#include <bits/stdc++.h>
using namespace std;

int main()
{
    cout<<"Nearest Smaller to Left"<<endl;
    int n;
    cout<<"Enter the number of elements"<<endl;
    cin>>n;
    int arr[n];
    cout<<"Enter the elements of the array"<<endl;
    for(int i=0;i<n;i++)
    {
        cin>>arr[i];
    }
    stack<int> s;
    vector<int> result;
    for(int i=0;i<n;i++)
    {
        if(s.empty())
        {
            result.push_back(-1);
        }
        else
        {
            while(s.empty()==false && s.top()>=arr[i])
            {
                s.pop();
            }
            if(s.empty()) result.push_back(-1);
            else result.push_back(s.top());
        }
        s.push(arr[i]);
    }
    cout<<"Result"<<endl;
    for(int i=0;i<n;i++)
    {
        cout<<result[i]<<" ";
    }
    return 0;
}
