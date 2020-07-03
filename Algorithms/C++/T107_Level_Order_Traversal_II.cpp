class Solution {
public:
    vector<vector<int>> levelOrderBottom(TreeNode* root) {      
        queue<TreeNode*> q;
        vector<vector<int>> res;
        if(!root) return res;
        q.push(root);
        while(!q.empty()){
            vector<int> tmp;
            for(int i = q.size() - 1; i >= 0; i--){
                TreeNode* cur = q.front();
                q.pop();
                if(cur->left) q.push(cur->left);
                if(cur->right) q.push(cur->right);
                tmp.push_back(cur->val);
            }                
            res.push_back(tmp);
        }
        reverse(res.begin(), res.end());
        return res;
    }
};
