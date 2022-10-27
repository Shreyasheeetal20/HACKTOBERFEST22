#include<iostream>
using namespace std;
int fact(int n){
                      if(n==0 || n==1)
                      return 1;
                      else
                      return n*fact(n-1);
}
int main(){
                      int n,r;
                      cin>>n>>r;
                      cout<<"nCr= "<<fact(n)/(fact(n-r)*fact(r))<<endl;
                      return 0;
}