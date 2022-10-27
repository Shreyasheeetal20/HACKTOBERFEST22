#include<iostream>
using namespace std;
int main(){
                      int n;
                      cin>>n;
                      for(int i=1;i<=n;i++){
                        for(int j=n-i;j>0;j--){
                            cout<<"  ";
                        }
                        for(int j=i;j>=1;j--){
                            cout<<j<<" ";
                        }
                        int k=2;
                        for(int j=1;j<i;j++){
                                            if(i>1)
                                            cout<<k<<" ";
                                            k++;
                                            
                        }
                        cout<<endl;
                      }
}