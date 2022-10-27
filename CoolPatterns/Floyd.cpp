//code to print floyd's triangle
#include<iostream>
using namespace std;
int main(){
                      int n;
                      cin>>n;
                      int k=1;
                      for(int i=1;i<=n;i++){
                                  for(int j=1;j<=i;j++){
                                            cout<<k<<" ";
                                            k++;

                                  }
                                  cout<<endl;
                      }
}
