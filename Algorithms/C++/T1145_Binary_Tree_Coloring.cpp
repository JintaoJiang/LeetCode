class Solution {
private:
    int p = 0, l = 0, r = 0;

public:
    bool btreeGameWinningMove(TreeNode* root, int n, int x) {
        helper(root, n, x);
        return (p > l + r + 1) || (l > p + r + 1) || (r > p + l + 1);
    }
    
    int helper(TreeNode* root, int n, int x) {
        if(root == NULL) return 0;
        int left = helper(root->left, n, x);
        int right = helper(root->right, n, x);
        if(root->val == x){
            this->l = left;
            this->r = right;
            this->p = n - left - right - 1;
        }
        return left + right + 1;
    }
};
