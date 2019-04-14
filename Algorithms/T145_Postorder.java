class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new LinkedList();
        Stack<TreeNode> stack = new Stack();
        List<Integer> res = new LinkedList();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }
}
