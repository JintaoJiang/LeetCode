class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        boolean[] seen = new boolean[edges.length + 1];
        Deque<Integer> deque = new LinkedList();
        Node[] nodes = new Node[edges.length + 1];
        for(int[] edge : edges){
            if(nodes[edge[0]] == null) nodes[edge[0]] = new Node(edge[0]); 
            if(nodes[edge[1]] == null) nodes[edge[1]] = new Node(edge[1]); 
            nodes[edge[0]].neighbors.add(nodes[edge[1]]);
            nodes[edge[1]].neighbors.add(nodes[edge[0]]);
        }
        findCycle(nodes[1], null, seen, deque);
        while((int)(deque.peekFirst()) != (int)(deque.peekLast())) seen[deque.pollFirst()] = false;        
        int[] res = null;
        for(int[] edge : edges){
            if(seen[edge[0]] && seen[edge[1]]) res = edge;
        }        
        return res;
    }
    
    private boolean findCycle(Node node, Node pre, boolean[] seen, Deque<Integer> deque){
        deque.addLast(node.val);
        seen[node.val] = true;
        for(Node nei : node.neighbors){
            if(nei == pre) continue;
            if(seen[nei.val]){
                deque.addLast(nei.val);
                return true;
            }
            if(findCycle(nei, node, seen, deque)) return true;
        }
        seen[node.val] = false;
        deque.pollLast();
        return false;
    }
    
}

class Node{
    int val;
    List<Node> neighbors = new LinkedList();
    public Node(int val) { this.val = val; }
}

