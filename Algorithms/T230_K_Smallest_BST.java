class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            k--;
            if(k == 0) return node.val;
            cur = node.right;
        }
        return 0;
    }
}