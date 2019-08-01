class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList();
        root.val = 1;
        q.add(root);
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int lo = 0, hi = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                TreeNode left = node.left, right = node.right;
                if(i == 0) lo = node.val;
                if(i == size - 1) hi = node.val;
                if(left != null){
                    left.val = node.val * 2 - 1;
                    q.add(left);
                }
                if(right != null){
                    right.val = node.val * 2;
                    q.add(right);
                }
            }
            res = Math.max(res, hi - lo + 1);
        }
        return res;
    }
}