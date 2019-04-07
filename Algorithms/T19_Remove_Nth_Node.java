class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head, prev = null;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if(prev == null){
            head = head.next;
        }else{
            prev.next = slow.next;
        }
        return head;
    }
}
