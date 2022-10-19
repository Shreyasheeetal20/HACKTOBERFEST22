class Solution {
public:
    bool isValid(string s) {
        stack<char>r;
        for(int i=0;i<s.size();i++){
            if((s[i]=='(')||(s[i]=='{')||(s[i]=='[')){
                r.push(s[i]);
            }
            else{
                if(r.empty())return 0;
                if(s[i]==')'){
                    if(r.top()=='(')r.pop();
                    else return 0;
                }
                else if(s[i]=='}'){
                    if(r.top()=='{')r.pop();
                    else return 0;
                }
                else if(s[i]==']'){
                    if(r.top()=='[')r.pop();
                    else return 0;
                }
            }
        }
        return r.empty();
    }
};
