#include<iostream>
using namespace std;

int main(){
    int i,n,a[100],index,value;
     cout << "Enter the limit of array" << endl;
    cin >> n;
    cout << "Enter the element of arrya" << endl;
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }
    cout<<"Enter index "<<endl;
    cin>>index;
    cout<<"enter the value of that index"<<endl;
    cin>>value;
    for (int i = n; i>=index; i--)
    {
        a[i]=a[i-1];
    }
    a[index]=value;
    for (int i = 0; i <=n; i++)
    {
        cout<<a[i]<<" ";
    }
    
    return 0;
}