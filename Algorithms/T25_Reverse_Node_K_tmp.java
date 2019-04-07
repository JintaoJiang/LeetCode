class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode left = head, right = head;
        ListNode start = null;
        int i = 1;
        boolean res = false;
        while(right != null){
            if(i == k){
                if(!res){
                    head = right;
                    res = true;
                }
                ListNode end = right.next;
                reverse(left, k);
                if(start != null) start.next = right;
                left.next = end;
                start = left;
                left = right = end;                
                i = 1;
            }else{
                right = right.next;
                i++;
            }                        
        }
        return head;
    }
    
    private void reverse(ListNode left, int k){
        ListNode pre = null;
        ListNode cur = left;
        while(k > 0){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            k--;
        }
    }
    
}

