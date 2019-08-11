class Solution {   
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        DFS(root);
        return max;
    }
    
    private int DFS(TreeNode root){
        if(root == null) return Integer.MIN_VALUE;
        int left = DFS(root.left);
        int right = DFS(root.right);
        if(left == Integer.MIN_VALUE) left = 0;
        if(right == Integer.MIN_VALUE) right = 0;
        int res = Math.max(root.val, Math.max(root.val + left, root.val + right));
        max = Math.max(max, Math.max(res, root.val + left + right));
        return res;         
    }
}