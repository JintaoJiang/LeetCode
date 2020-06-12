class Solution {
public:
    int distributeCoins(TreeNode* root) {
        int res = 0;
        function<int(TreeNode*)> dfs = [&](TreeNode* r) {
            if(r == NULL) return 0;
            int left = dfs(r->left);
            int right = dfs(r->right);
            res += abs(left) + abs(right);
            return r->val + left + right - 1;
        };
        dfs(root);
        return res;
    }
};
