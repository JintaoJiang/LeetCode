class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode res = head.next;
        helper(head, null);
        return res;
    }
    
    private void helper(ListNode cur, ListNode pre){
        if(cur == null || cur.next == null) return;
        ListNode next = cur.next;
        if(pre != null) pre.next = next;
        cur.next = next.next;
        next.next = cur;
        helper(cur.next, cur);
    }
}
