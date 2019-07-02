class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = head, even, evenHead;
        if(odd == null) return head;
        even = odd.next;
        evenHead = odd.next;
        while(odd != null && even != null){
            if(even.next == null) break;
            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            even = even.next;
        }        
        odd.next = evenHead;
        return head;
    }
}