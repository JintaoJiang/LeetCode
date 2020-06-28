class Solution {
public:
    int res = 0;
    
    int minCameraCover(TreeNode* root) {
        int* res = helper(root);
        return min(res[1], res[2]);
    }
    
    int* helper(TreeNode* root){
        if(root == NULL){
            return new int[3]{0, 0, INT_MAX / 2};
        }
        int* left = helper(root->left);
        int* right = helper(root->right);
        int state0 = left[1] + right[1];
        int state1 = min(min(left[1] + right[2], left[2] + right[1]), left[2] + right[2]);
        int state2 = 1+ min(min(left[0], left[1]), left[2]) + min(min(right[0], right[1]), right[2]);
        return new int[3]{state0, state1, state2};
    }
    
};
