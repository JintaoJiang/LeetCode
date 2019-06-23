class Solution {    
    public int maxPathSum(TreeNode root) {
        return helper(root)[0];
    }
    
    //first element is max path, second element is max distance
    private int[] helper(TreeNode root){
        if(root == null) return new int[]{Integer.MIN_VALUE, 0}; 
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] res = new int[2];
        int currMax = Math.max(Math.max(left[1] + root.val, right[1] + root.val), Math.max(left[1] + right[1] + root.val, root.val));
        res[0] = Math.max(Math.max(left[0], right[0]), currMax);
        res[1] = Math.max(Math.max(left[1], right[1]) + root.val, root.val);
        return res;
    } 
}