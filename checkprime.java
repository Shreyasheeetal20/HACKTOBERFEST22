import java.util.*;
//this is java program to check if given no is prime or not 
public class checkprime {


    int check(int n)
    {  int flag=0;

        if(n<=1)
        {
            return 0;
        }
        
        for(int i=2;i<n/2;i++)
        {
            if(n%i==0)
            {
                flag=1;
                break;
            }
        }



        return flag;
    }

    public static void main(String[] args) {
        System.out.println("This is program to check if given no is prime or not ");

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter any number :");
        int n=sc.nextInt();
         
        checkprime cp=new checkprime();
        int ans=cp.check(n);


        if(ans==0)
        {
            System.out.println(n+ " "+" is not a prime no !");
        
        
        }
        else
        {
            System.out.println(n+" "+ " is a prime no !");
        }


    }
    
}
