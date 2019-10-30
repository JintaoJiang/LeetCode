class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;
        if(n == 0) return null;
        TreeNode root = new TreeNode(pre[0]);  
        if(n == 1) return root;
        
        int left = 0;
        for(int i = 0; i < n - 1; i++){
            if(post[i] == pre[1]){
                left = i;
                break;
            } 
        }
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, left + 2), Arrays.copyOfRange(post, 0, left + 1));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, left + 2, n), Arrays.copyOfRange(post, left + 1, n));

        return root;
    }
}