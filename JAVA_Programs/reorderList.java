// Reorder list problem of leetcode

class Solution {
    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode first = head;
        ListNode second = reverse(slow.next);
        slow.next = null;
        
        while(second != null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }

    }

    public static ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode prev = null;

        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }


}
