class Solution {
public:
    string longestPalindrome(string s) {
        int n=s.size();
        int dp[n][n];
        
        int strt=0,mx=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)dp[i][j]=1;
                else dp[i][j]=0;
            }
        }
        
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s[i]==s[j]){
                    dp[i][j] = ((j-i)==1)||dp[i+1][j-1];
                }
                if(dp[i][j]==1){
                    if((j-i+1)>mx){
                        strt=i;
                        mx=j-i+1;
                    }
                }
            }
        }
        
        return s.substr(strt,mx);
        
    }
};
