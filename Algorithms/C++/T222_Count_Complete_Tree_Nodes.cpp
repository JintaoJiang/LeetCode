class Solution {
public:
    int countNodes(TreeNode* root) {
        if(!root) return 0;
        int lc = 0, rc = 0;
        TreeNode *left = root, *right = root;
        while(left){ ++lc; left = left->left; }
        while(right){ ++rc; right = right->right; }
        if(lc == rc) return pow(2, lc) - 1;
        return 1 + countNodes(root->left) + countNodes(root->right);
    }
};
