import java.util.Arrays;
 
class Main
{
    /*
     `arr` ——> the input integer array to be sorted
       `k` ——> a number such that all integers are in range `0…k-1`
    */
    public static void countsort(int[] arr, int k)
    {
        // create an integer array of size `n` to store the sorted array
        int[] output = new int[arr.length];
 
        // create an integer array of size `k + 1`, initialized by all zero
        int[] freq = new int[k + 1];
 
        // using the value of each item in the input array as an index,
        // store each integer's count in `freq[]`
        for (int i: arr) {
            freq[i]++;
        }
 
        // calculate the starting index for each integer
        int total = 0;
        for (int i = 0; i < k + 1; i++)
        {
            int oldCount = freq[i];
            freq[i] = total;
            total += oldCount;
        }
 
        // copy to the output array, preserving the order of inputs with equal keys
        for (int i: arr)
        {
            output[freq[i]] = i;
            freq[i]++;
        }
 
        // copy the output array back to the input array
        Arrays.setAll(arr, i -> output[i]);
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 4, 2, 10, 10, 1, 4, 2, 1, 10 };
 
        // range of array elements
        int k = 10;
 
        countsort(arr, k);
        System.out.println(Arrays.toString(arr));
    }
}
