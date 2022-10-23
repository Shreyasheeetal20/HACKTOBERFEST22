// Partiton list (problem of leetcode)

class Solution {
    public ListNode partition(ListNode head, int x) {
        ArrayList<Integer> l = new ArrayList<>();

        ListNode cur = head;
        while(cur!=null){
            if(cur.val < x){
                l.add(cur.val);
            }
            cur = cur.next;
        }
        cur = head;
        while(cur!=null){
            if(cur.val >= x){
                l.add(cur.val);
            }
            cur = cur.next;
        }

        ListNode res = new ListNode(0);
        ListNode temp = res;
        int n = l.size();
        for(int i=0;i<n;i++){
            int a = l.get(i);
            ListNode node = new ListNode(a);
            temp.next = node;
            temp = temp.next;
        }

        return res.next;

    }
}
