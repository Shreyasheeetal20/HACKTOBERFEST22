import java.util.*;
public class Main
{
    public static int findUnique_elementPresentInArray(int[] arr){
        int n=arr.length;
        int num=0;
        for(int i=0;i<n;i++){
       num=arr[i]^num;
        }
        return num;
    }
	public static void main(String[] args) {
	Main obj=new Main();
	int[] arr={2,3,4,3,2};
	int x=obj.findUnique_elementPresentInArray(arr);
	System.out.print(x);
	}
}
