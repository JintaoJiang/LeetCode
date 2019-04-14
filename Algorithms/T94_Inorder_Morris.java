class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList();
        while(root != null){
            TreeNode left = root.left;
            if(left == null){
                res.add(root.val);
                root = root.right;
            }else{
                while(true){
                    if(left.right == null){
                        left.right = root;
                        root = root.left;
                        break;
                    }else if(left.right == root){
                        left.right = null;
                        res.add(root.val);
                        root = root.right;
                        break;
                    }else{
                        left = left.right;
                    }
                }
            }
        }
        return res;
    }
}
