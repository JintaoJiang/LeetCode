class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        if(n == 0) return new LinkedList<Integer>();
        int[] res = new int[n];
        TreeNode root = new TreeNode(n - 1, nums[n - 1]);
        for(int i = n - 2; i >= 0; i--){
            TreeNode curr = root;
            TreeNode node = new TreeNode(i, nums[i]);
            while(true){
                if(node.val <= curr.val){
                    curr.leftCount++;
                    if(curr.left == null){
                        curr.left = node;
                        break;
                    }else{
                        curr = curr.left;
                    }                  
                }else{
                    res[node.i] += curr.leftCount + 1;
                    if(curr.right == null){
                        curr.right = node;
                        break;
                    }else{
                        curr = curr.right;
                    }
                }
            }                
        }
        List<Integer> list = new LinkedList();
        for(int i = 0; i < n; i++){
            list.add(res[i]);
        }
        return list;
    }
}

class TreeNode{
    int i, val, leftCount = 0;
    TreeNode left;
    TreeNode right;
    public TreeNode(int i, int val){
        this.i = i;
        this.val = val;
    }
}
