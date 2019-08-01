class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode node = null;
            for(int i = 0; i < size; i++){
                node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            res.add(node.val);
        }
        return res;
    }
}