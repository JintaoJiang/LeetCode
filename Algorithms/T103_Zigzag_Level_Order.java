class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            LinkedList<Integer> temp = new LinkedList();
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(level % 2 == 0) temp.add(node.val);
                else temp.addFirst(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            res.add(temp);
            level++;
        }
        return res;
    }
}