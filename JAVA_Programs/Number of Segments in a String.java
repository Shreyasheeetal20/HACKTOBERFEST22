// Problem Link: https://leetcode.com/problems/number-of-segments-in-a-string/

class Solution {
    public int countSegments(String s) {
        if(s.length()== 0){
            return 0;
        }
        int count = 0;
        String[] str = s.split(" ",0);
		for(String a:str){
            if(a.length()!=0){
                count++;
            }
        }
        return count;
    }
}
