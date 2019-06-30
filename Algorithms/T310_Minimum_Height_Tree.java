class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            List<Integer> r = new LinkedList();
            r.add(0);
            return r;
        } 
        Node[] nodes = new Node[n];
        for(int[] edge : edges){
            if(nodes[edge[0]] == null) nodes[edge[0]] = new Node(edge[0]);
            if(nodes[edge[1]] == null) nodes[edge[1]] = new Node(edge[1]);
            nodes[edge[0]].nei.add(nodes[edge[1]]);
            nodes[edge[1]].nei.add(nodes[edge[0]]);
        }
        Node[] pre = new Node[n];
        //find the most distant node
        Node end1 = BFS(nodes[0], pre);
        //find the longest path
        Node end2 = BFS(end1, pre);
        //find the midpoint
        Node cur = end2;
        List<Integer> res = new LinkedList();
        for(int i = 1; i <= end2.level / 2; i++){
            cur = pre[cur.val];
        }
        res.add(cur.val);
        if(end2.level % 2 == 1) res.add(pre[cur.val].val);
        return res;
    }
    
    private Node BFS(Node root, Node[] pre){
        boolean[] visited = new boolean[pre.length];
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        Node last = null;
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                last = node;
                visited[node.val] = true;
                for(Node n : node.nei){
                    if(!visited[n.val]){
                        queue.add(n);
                        pre[n.val] = node;
                        n.level = level;
                    }
                }
            } 
            level++;
        }
        return last;
    } 
}

class Node{
    int val;
    int level;
    List<Node> nei = new LinkedList();
    public Node(int val) { this.val = val; }
}