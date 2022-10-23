// Problem Link : https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution {
    public int search(int[] nums, int target) {
        int l= 0, r= nums.length-1, pos= 0, p= -1, mid;    
        int nums1[]= nums.clone();
        Arrays.sort(nums);
        while (l <= r)
        {
            mid= l + (r-l)/2;
            if (nums[mid] == target)
            {
                p= mid;
                break;
            }
            else if (nums[mid] > target)
                r= mid-1;
            else
                l= mid+1;
        }
        
        if (p == -1)
            return -1;
        
        l= 0; r= nums1.length-1;
        while (l < r)
        {
            if (nums1[l+1] < nums1[l])
            {
                pos= l+1;
                break;
            }
            else 
                l++;
            
            if (nums1[r-1] > nums1[r])
            {
                pos= r;
                break;
            }
            else 
                r--;
        }
        
        pos= nums1.length-pos;
        if (p > -1 && p < pos)
            return p+nums1.length-pos;
        else if (p > -1 && p >= pos)
            return p-pos;
        
        return -1;
    }
}
