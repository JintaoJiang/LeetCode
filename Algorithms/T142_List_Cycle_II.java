public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        int cycleLen = 0;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            cycleLen++;
            if(slow == fast){
                hasCycle = true;
                break;
            }
        }
        if(hasCycle){
            slow = head;
            fast = head;
            while(cycleLen-- > 0) fast = fast.next;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }
}