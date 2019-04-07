class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode pre = start;
        ListNode cur = head;
        head = head.next;
        while(cur != null){
            ListNode next = cur.next;
            if(next == null) break;
            pre.next = next;
            cur.next = next.next;
            next.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
