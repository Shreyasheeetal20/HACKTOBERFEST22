//This is a sample program to find the value 9 for how many repeated times in an array 
class sample 
{
	public static void main(String[] args) 
	{
		int[] arr={10,9,8,5,4,1,2,9}; 
		int count=0;
		for(int i=0; i<=7;i++)
		{
			if(arr[i]==9)
			{
				count++;
			}
		}
		System.out.println("9 is present for "+ count + " times");
	}
}
