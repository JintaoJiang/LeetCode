class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;
        helper(head);
        return head;
    }
    
    private Node helper(Node head){
        if(head.child == null){
            if(head.next == null) return head;
            return helper(head.next);
        }else{
            Node next = head.next, child = head.child;
            head.next = child;
            head.child = null;
            child.prev = head;
            Node tail = helper(child);
            if(next != null){
                tail.next = next;
                next.prev = tail;
                return helper(tail);
            }
            return tail;
        }
    }
}
