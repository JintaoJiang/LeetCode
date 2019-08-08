class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((x, y) -> x.val - y.val);
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null) pq.add(lists[i]);
        }
        ListNode curr = new ListNode(0);
        ListNode head = curr;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            ListNode next = node.next;
            if(next != null) pq.add(next);
            curr.next = node;
            curr = curr.next;
        }
        return head.next;
    }
}