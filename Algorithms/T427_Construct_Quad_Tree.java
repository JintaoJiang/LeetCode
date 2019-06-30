class Solution {
    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length);
    }
    
    private Node helper(int[][] grid, int i, int j, int len){
        Node node = new Node();
        if(len == 1){
            node.isLeaf = true;
            node.val = grid[i][j] == 1;
            return node;
        }
        int nextLen = len / 2;
        node.topLeft = helper(grid, i, j, nextLen);
        node.topRight = helper(grid, i, j + nextLen, nextLen);
        node.bottomLeft = helper(grid, i + nextLen, j, nextLen);
        node.bottomRight = helper(grid, i + nextLen, j + nextLen, nextLen);
        if(node.topLeft.isLeaf && node.topRight.isLeaf && node.bottomLeft.isLeaf && node.bottomRight.isLeaf && node.topLeft.val == node.topRight.val && node.topLeft.val == node.bottomLeft.val && node.topLeft.val == node.bottomRight.val){
            node.val = node.topLeft.val;
            node.topLeft = null;
            node.topRight = null;
            node.bottomLeft = null;
            node.bottomRight = null;
            node.isLeaf = true;
        }
        return node;
    }
}
