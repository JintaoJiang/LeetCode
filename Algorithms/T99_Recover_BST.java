class Solution {
    private TreeNode pre = null;
    private List<TreeNode> err = new LinkedList();
    
    public void recoverTree(TreeNode root) {
        search(root);
        if(err.size() == 2){
            int temp = err.get(0).val;
            err.get(0).val = err.get(1).val;
            err.get(1).val = temp;
        }else{
            int temp = err.get(0).val;
            err.get(0).val = err.get(3).val;
            err.get(3).val = temp;
        }        
    }
    
    private void search(TreeNode root){
        if(root == null) return;
        search(root.left);
        if(pre != null && pre.val >= root.val){
            err.add(pre);
            err.add(root);
        }
        pre = root;
        search(root.right);
    }
}