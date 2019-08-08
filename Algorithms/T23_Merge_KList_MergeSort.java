public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        return partition(0, lists.length - 1, lists);
    }
    
    public ListNode partition(int i, int j, ListNode[] lists){
        if(i == j)
            return lists[i];
        ListNode l1 = partition(i, (i + j) / 2, lists);
        ListNode l2 = partition((i + j) / 2 + 1, j, lists);
        return merge(l1, l2);
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) 
            return l2;
        if(l2 == null)
            return l1;
        ListNode head = null;
        if(l1.val < l2.val){
            head = l1;
            head.next = merge(l1.next, l2);
        }else{
            head = l2;
            head.next = merge(l1, l2.next);
        }
        return head;
    }
}