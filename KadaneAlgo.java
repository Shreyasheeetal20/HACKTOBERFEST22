package binarySearchAlgo;

public class KadaneAlgo {

	public static void main(String[] args) {
		
		int a[] = {2,3,-5,6,-2,4}; //mix array
		int b[] = {-9,-5,-6,-4}; //negative array
		
		int result = maxSumSubArray(a);
		int result1 = maxSumSubArrayAllNegative(b);
		
		System.out.println(result);
		System.out.println(result1);

	}
	
	static int maxSumSubArray(int a[]) {
		int maxsum =0;
		int cursum = 0;
		
		for(int i =0; i <a.length;i++) {
			cursum = cursum + a[i];
			if(cursum > maxsum) {
				maxsum = cursum;
			}
			if(cursum < 0) {
				cursum = 0;
			}
		}
		
		return maxsum;
	}
	
	static int maxSumSubArrayAllNegative(int a[]) {
		int maxsum =a[0];
//		int maxsum = Integer.MIN_VALUE;
		int cursum = 0;
		
		for(int i =0; i <a.length;i++) {
			cursum = cursum + a[i];
			if(cursum > maxsum) {
				maxsum = cursum;
			}
			if(cursum < 0) {
				cursum = 0;
			}
		}
		
		return maxsum;
	}

}
