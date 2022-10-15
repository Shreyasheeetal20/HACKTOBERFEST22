import java.io.*;
import java.util.*;

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;
    
    public LinkedListNode(T data) {
        this.data = data;
    }
}

public class Runner {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static LinkedListNode<Integer> takeInput() throws IOException {
        LinkedListNode<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            if(head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
        }

        return head;
    }
    
    public static void print(LinkedListNode<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
        if (N == 0 || head == null)
            return head;
        if (M == 0)
            return null;
        
        int cm= 0, cn= 0;
        LinkedListNode<Integer> temp= head, hc= head;
        
        while (temp != null)
        {
            cm++;
            if (cm < M)
                hc= hc.next;        
            else
        		cn++;  
            
            if (cn > 0 && cn <= N && temp.next == null)
                hc.next= null;
            else if (cn == N+1){
                hc.next= temp.next;
                hc= temp.next;
                cn= 0;
                cm= 0;
            }         
            temp= temp.next;
        }
        return head;
	  }
  
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {
            
            LinkedListNode<Integer> head = takeInput();
            String[] m_n = br.readLine().trim().split("\\s");

            int m = Integer.parseInt(m_n[0]);
            int n = Integer.parseInt(m_n[1]);

            LinkedListNode<Integer> newHead = skipMdeleteN(head, m, n);
            print(newHead);
            
            t -= 1;
        }

    }
}
