// Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

// Return the minimized largest sum of the split.

// A subarray is a contiguous part of the array.

 

// Example 1:

// Input: nums = [7,2,5,10,8], k = 2
// Output: 18
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.




class Solution {
        public static int splitArray(int [] ar,int m){
        int start =ar[0],end=0;
        for(int i=0;i<=ar.length-1;i++){
            
            start =Math.max(start,ar[i]);
            end +=ar[i];
        }
        while(start<end){
            int pieces =1;
            int mid =start +(end -start)/2;
            int sum =0;
            for(int num:ar){
                if(sum+num<=mid){
                    sum+=num;
                }
                else{
                    pieces++;
                    sum=num;
                }
            }
            if(pieces<=m){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }
        
    
}