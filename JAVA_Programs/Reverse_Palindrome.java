import java.util.Scanner;

public class ReversePalindrome 
{	
	public static String reverseString(String str)
  {
		String emptyString = "";
		for(int i = 0; i<str.length();i++) {
			emptyString = str.charAt(i) + emptyString;
		}
		return emptyString;
	}	

	public static void main(String[] args) 
  {
		Scanner s = new Scanner(System.in);
		String str1 = s.nextLine();
		String reverse = reverseString(str1);
		System.out.println(reverse);
		s.close();
		if(str1.equals(reverse)) 
    {
			System.out.println("Palindrome");
		}
    else 
    {
			System.out.println("Not Palindrome");
		}
	}
}
