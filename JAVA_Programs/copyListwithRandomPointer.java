// Copy List with Random Pointer problem of leetcode

class Solution {
    public Node copyRandomList(Node head) {
        
        if(head==null){
            return head;
        }

        Node cur = head;
        while(cur!=null){
            Node temp = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = temp;
            cur = temp;
        }

        cur = head;
        while(cur!= null){
            if(cur.next!=null){
                if(cur.random!=null){
                    cur.next.random = cur.random.next;
                }
                else{
                    cur.next.random=null;
                }
            }
            cur = cur.next.next;
        }

        Node org = head;
        Node copy = head.next;
        Node temp = copy;
        while(org!=null){
            org.next = org.next.next;
            if(copy.next!=null){
                copy.next = copy.next.next;
            }
            org = org.next;
            copy = copy.next;
        }
        return temp;

    }
}
