class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode res = new ListNode(0), cur = head;
        while(cur != null){
            ListNode next = cur.next, p = res;
            while(p.next != null && p.next.val <= cur.val) p = p.next;
            cur.next = p.next;
            p.next = cur;
            cur = next;
        }
        return res.next;
    }
}