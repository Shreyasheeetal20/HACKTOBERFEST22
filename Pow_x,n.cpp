// this is the solution of the pow(x,n) question in leetcode
// https://leetcode.com/problems/powx-n/

/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <bits/stdc++.h>

double myPow(double x, int n) {
    long long pow = n;
    double ans = 1.0; 
    if(n<0) pow = -1*pow; 
    while(pow)
    {
        if(pow%2!=0)
        {
            ans*=x; 
            pow--; 
        }
        else
        {
            x*=x; 
            pow/=2; 
        }
          
    }
    if(n<0) return double(1.0)/double(ans);
    return double(ans); 
}

using namespace std;

int main()
{
    int x, n; 
    cout<<"Enter the base: \n"; 
    cin>>x; 
    cout<<"Enter the power: \n"; 
    cin>>n;
    int ans = myPow(x,n); 
    cout<<x<<"^"<<n<<" =  "<<ans<<"\n"; 

    return 0;
}
