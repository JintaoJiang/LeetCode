class Solution {
    private int res = 0;
    
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return res;
    }
    
    private void helper(TreeNode root, int sum){
        if(root == null) return;
        int currSum = sum * 10 + root.val;
        if(root.left == null && root.right == null){
            res += currSum;
        }else{
            helper(root.left, currSum);
            helper(root.right, currSum);
        }       
    }
}