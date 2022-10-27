class Solution {
public:
    string countAndSay(int n) {
        if(n==1){
            return "1";
        }
        
        string ans = countAndSay(n-1);
        int i = 0;
        
        string res = "";
        while(i<ans.length()){
            int count = 1;
            while(i+1<ans.length() && ans[i]==ans[i+1]){
                count++; i++;
            }
            
            res+= to_string(count);
            res.push_back(ans[i]);
            i++;
        }
        
        return res;
    }
};