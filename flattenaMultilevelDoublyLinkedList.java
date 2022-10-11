// Flatten a multilevel doubly linked list problem of Leetcode

class Solution {
    public Node flatten(Node head) {
        Node cur = head;
        Node tail = head;
        Stack<Node> s = new Stack<>();

        while(cur!=null){
            if(cur.child !=null){
                Node child = cur.child;
                if(cur.next!=null){
                    s.push(cur.next);
                    cur.next.prev = null;
                }
                cur.next = child;
                child.prev = cur;
                cur.child = null;
            }
            tail = cur;
            cur = cur.next;
        }

        while(!s.isEmpty()){
            cur = s.pop();
            tail.next = cur;
            cur.prev = tail;
            while(cur!=null){
                tail = cur;
                cur = cur.next;
            }
        }

        return head;
    }
}
