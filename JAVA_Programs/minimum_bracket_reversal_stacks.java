import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int countBracketReversals(String string) {
        Stack<Character> stk= new Stack<>();
        int i, count= 0;
        
        stk.push(string.charAt(0));
        
        for (i= 1; i < string.length(); i++)
        {
        	if (!stk.isEmpty() && stk.peek() == '{' && string.charAt(i) == '}')   // For balanced pair of brackets -> { }
                stk.pop();
            else 
                stk.push(string.charAt(i));                
        }
        
        char c1, c2;
        while (!stk.isEmpty()){
            c1= stk.peek();
            stk.pop();
            if (!stk.isEmpty()){
            	c2= stk.peek();            
            	stk.pop();
            }
            else 
                return -1;
            
            if (c1 == c2) 	// c1= { and c2= {    or     c1= } and c2= }
                count++;
            else			// c1= } and c2= {
                count+= 2;
        }
        
        return count;
	  }
  
    public static void main(String[] args) throws NumberFormatException, IOException {
    	System.out.println(countBracketReversals(br.readLine().trim()));
    }
}
