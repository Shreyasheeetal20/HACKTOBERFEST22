import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static boolean checkRedundantBrackets(String exp) {
        Stack<Character> stk= new Stack<>();
        int i, len;
        
        for (i= 0; i < exp.length(); i++)
        {
            stk.push(exp.charAt(i));
            if (stk.peek() == ')'){
                len= 0;
                while (stk.peek() != '('){                    
                    stk.pop();
                    len++;
                }
                stk.pop();
                if (len-1 <= 1)
                    return true;
            }                
        }
        return false;
	  }
    
    public static void main(String[] args) throws NumberFormatException, IOException {

    	String expression = br.readLine().trim();
    	System.out.println(checkRedundantBrackets(expression));
    }
}
