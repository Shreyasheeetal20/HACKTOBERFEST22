class Solution {
    public int[] BeautifulArray(int n) {
        int[] ans = new int[n];
        for(int i = 0; i  < n; i++){
            ans[i] = i+1;
        }
        recursion(ans, 0, n-1);
        return ans;
    }
    
    public void recursion(int[] arr, int left, int right){
        if(left >= right)
            return;
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> r = new ArrayList<>();
		
        boolean alt = true;
							
        for(int i = left; i <= right; i++){ 
            if(alt)
                l.add(arr[i]);
            else
                r.add(arr[i]);
            alt = !alt;
        }

        for(int i = left; i <= right; i++){
            if(!l.isEmpty())
                arr[i] = l.remove(0);
            else
                arr[i] = r.remove(0);
        }
        recursion(arr, left, (right+left)/2);
        recursion(arr, (left+right)/2+1, right);
    }
}
