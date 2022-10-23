package Array_Distinct_Number;
import java.util.Scanner;
//29 January, 2022
//All Copyright © goes to Hamim Reza Shammo (https://github.com/hrshammo/)
public class Main {
    static void printDistinct(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
        {
            int j;
            for (j = 0; j < i; j++)
                if (arr[i] == arr[j])
                    break;
            if (i == j)
                System.out.print( arr[i] + " ");
        }
    }
    static int countDistinct(int arr[], int n)
    {
        int count = 1;
        for (int i = 1; i < n; i++)
        {
            int j = 0;
            for (j = 0; j < i; j++)
                if (arr[i] == arr[j])
                    break;
            if (i == j)
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
	// write your code here
        int[] arr= new int [10];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter ten numbers");
        for(int i=0;i<10;i++){
            arr[i]=input.nextInt();
        }
        System.out.println("The distinct numbers are: ");
        printDistinct(arr,10);
        System.out.println();
        System.out.println("The number of distinct number: "+countDistinct(arr,10));
    }
}
