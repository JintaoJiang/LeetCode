class Solution {  
    private TreeNode pre = null;
    
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(!isValidBST(root.left)) return false;
        if(pre != null && pre.val >= root.val) return false;
        pre = root;
        return isValidBST(root.right);
    }
}