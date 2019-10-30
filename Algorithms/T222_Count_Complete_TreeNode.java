class Solution {
    public int countNodes(TreeNode root) {
        int h = height(root);
        if(h == -1) return 0;
        int hRight = height(root.right);
        if(hRight == h - 1) return (1 << h) + countNodes(root.right);
        return (1 << (h - 1)) + countNodes(root.left);
    }
    
    private int height(TreeNode root){
        return root == null ? -1 : 1 + height(root.left);
    }
}