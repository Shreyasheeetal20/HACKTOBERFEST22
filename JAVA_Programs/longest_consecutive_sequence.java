class Solution {
    public int longestConsecutive(int[] arr) {
        HashMap <Integer, Boolean> map= new LinkedHashMap<>();
        int i, k= 0, maxlen= 0, maxlenc= 0;
        
        for (i= 0; i < arr.length; i++)
            map.put(arr[i], true);
        
        for (i= 0; i < arr.length; i++)
        {
            if (map.get(arr[i]) == true)
            {
                k= 1;
                maxlenc= 1;
                
            	while (map.containsKey(arr[i] + k)){
                    map.put(arr[i] + k, false);
                    maxlenc++;
                    k++;
                }
                
                k= -1;
                while (map.containsKey(arr[i] + k)){
                    map.put(arr[i] + k, false);
                    maxlenc++;
                    k--;
                }
            	
                if (maxlenc > maxlen) 
                    maxlen= maxlenc;
            }
        }
        return maxlen;
    }
}
