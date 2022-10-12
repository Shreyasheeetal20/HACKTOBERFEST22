import java.util.*;
public class comparison_game {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i=1,j=0,k=0;
        while(i<=5)
        {
            
            System.out.println("Enter your number");
            int n=sc.nextInt();
            int random=(int)(Math.random()*21);
            System.out.println("Number entered by computer is "+random);
            if(n>random)
            {
                j++;
            }
            else if(n<random)
            {
                k++;
            }
                i++;
            }
            if(j<k)
            System.out.println("Computer Won");
            else if(j>k)
            System.out.println("You Won");
            else
            System.out.println("Match Tie");
                        
        }
}
