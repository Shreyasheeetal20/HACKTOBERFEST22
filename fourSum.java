public List<List> fourSum(int[] nums, int target) {

    List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> quad= new ArrayList<Integer>();
    Set<List<Integer>> uniq=new HashSet<List<Integer>>();
    //uniq.add(null);
    Arrays.sort(nums);
    int i,j,k,l,flag;
    flag=0;
    //int sum;
    //long sum=0;
    for (i=0;i<nums.length-3;i++)
    {
        for(j=i+1;j<nums.length-2;j++)
        {
            k=j+1;
            l=nums.length-1;
            while(k<l)
            {
               // sum=nums[i]+nums[j]+nums[k]+nums[l];
                if(nums[i]+nums[j]+nums[k]+nums[l]==target)
                {
                    quad.add(nums[i]);
                    quad.add(nums[j]);
                    quad.add(nums[k]);
                    quad.add(nums[l]);
                    uniq.add(quad);
                    flag=1;
                    quad = new ArrayList<Integer>();
                    k++;
                    l--;
                }
                else{
                    if((nums[i]+nums[j]+nums[k]+nums[l])<target){
                        k++;
                    }else
                    {
                        l--;
                    }
                }
            }
        }
    }
   if(uniq.isEmpty())
       return ret;
    for(List<Integer> itr : uniq)
    {
       ret.add(itr) ;
    }
    
 // if(flag==0)
   //   return [];
    return ret;
}
}
