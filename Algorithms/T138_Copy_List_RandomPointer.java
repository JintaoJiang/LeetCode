class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node, Node> map = new HashMap();
        map.put(null, null);
        Node res = new Node();
        Node last = res, temp = head;
        while(head != null){
            Node cur = new Node(head.val, null, null);
            map.put(head, cur);
            last.next = cur; 
            last = cur;
            head = head.next;
        }
        head = temp;
        while(head != null){
            Node cur = map.get(head);
            Node random = map.get(head.random);
            cur.random = random;
            head = head.next;
        }        
        return res.next;
    }
}