import java.util.Scanner;
public class Main
{
  
    static void print(int a [][])
    {
       int top=0,bottom=a.length-1,left=0,right=a[0].length-1,dir,i;
	    while(top<=bottom&& left<=right)
	    {
	        dir=1;
	        for(i=left;i<=right;i++)
	        {
	            System.out.print(a[top][i]+",");
	        }
	        top++;  dir=2;
	        for(i=top;i<=bottom;i++)
	        {
	            System.out.print(a[i][right]+",");
	        }
	        dir=3;  right--;
	        for(i=right;i>=left;i--)
	        {
	           System.out.print(a[bottom][i]+","); 
	        }
	        dir=4;  bottom--;
	        for(i=bottom;i>=top;i--)
	        {
	            System.out.print(a[i][left]+",");
	        }
	        left++;
	   }
    }
	public static void main(String[] args) 
	{
	      Scanner sc=new Scanner (System.in);
	    int i,j;
	    System.out.println("size of sq matrix :-");
	    int n=sc.nextInt();
	    int a[][]=new int[n][n];
	    for(i=0;i<n;i++)
	    {
	        for(j=0;j<n;j++)
	        {
	            a[i][j]=sc.nextInt();
	        }
	    }
		print(a);
	}
}

