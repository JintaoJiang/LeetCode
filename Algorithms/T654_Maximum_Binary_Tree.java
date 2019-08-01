class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        if(n == 0) return null;
        Stack<TreeNode> stack = new Stack();
        for(int i = 0; i < n; i++){
            TreeNode node = new TreeNode(nums[i]);    
            while(!stack.isEmpty() && nums[i] > stack.peek().val) node.left = stack.pop();
            if(!stack.isEmpty()) stack.peek().right = node;
            stack.push(node);
        }
        TreeNode root = null;
        while(!stack.isEmpty()) root = stack.pop();
        return root;
    }
}