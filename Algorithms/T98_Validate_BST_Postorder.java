class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root).res;
    }
    
    private Tuple helper(TreeNode root){
        if(root == null) return new Tuple(0, 0, true, true);
        Tuple left = helper(root.left);
        Tuple right = helper(root.right);
        if(!left.res || !right.res || (!left.none && root.val <= left.max) || (!right.none && root.val >= right.min)) return new Tuple(0, 0, false, false);
        long min = left.none ? root.val : left.min;
        long max = right.none ? root.val : right.max;
        return new Tuple(min, max, true, false);
    }
}
class Tuple{
    long min, max; boolean res, none;
    public Tuple(long min, long max, boolean res, boolean none) { this.min = min; this.max = max; this.res = res; this.none = none; }
}