#include <iostream>
#include <stack>
using namespace std;
int main(){
	int n;
	cin>>n;
	int a[n];
	for(int i=0;i<n;++i){
		cin>>a[i];
	}
	stack <int> span;
	for(int i=0;i<n;++i){
		while(span.empty()==false and a[span.top()]<a[i]){
			span.pop();
		}
		int sp=span.empty()?i+1:(i-span.top());
		cout<<sp<<" ";
		span.push(i);
	}
	cout<<"END";
}