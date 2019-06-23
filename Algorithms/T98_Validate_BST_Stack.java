class Solution {      
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root, prev = null;
        while(!stack.isEmpty() || curr != null){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            if(prev != null && prev.val >= node.val) return false;
            prev = node;
            curr = node.right;
        }
        return true;
    }
}