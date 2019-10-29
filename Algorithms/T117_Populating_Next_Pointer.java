class Solution {
    public Node connect(Node root) {
        Node res = root;
        while(root != null){
            Node head = new Node();
            Node cur = head;
            while(root != null){
                if(root.left != null){
                    cur.next = root.left;
                    cur = cur.next;
                }
                if(root.right != null){
                    cur.next = root.right;
                    cur = cur.next;
                }
                root = root.next;
            }
            root = head.next;
        }
        return res;
    }
}