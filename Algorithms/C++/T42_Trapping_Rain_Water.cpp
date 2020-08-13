class Solution {
public:
    int trap(vector<int>& height) {
        stack<int> s;
        int res = 0;
        for(int i = 0; i < height.size(); i++){
            int h = height[i];
            while(!s.empty() && h > height[s.top()]){
                int idx = s.top();
                s.pop();
                if(s.empty()) break;
                res += (min(h, height[s.top()]) - height[idx]) * (i - s.top() - 1);
            }
            s.push(i);
        }
        return res;
    }
};
