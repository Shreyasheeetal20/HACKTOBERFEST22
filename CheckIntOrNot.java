import java.util.Scanner;

public class CheckIntOrNot {
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        //boolean b = sc.hasNextInt();
        boolean b = sc.hasNextFloat();
        //System.out.println(b);
        if(b){
            System.out.println("Entered Number is a Float");
        } else {
            System.out.println("Entered Number is not a Float");
        }
    }
}
