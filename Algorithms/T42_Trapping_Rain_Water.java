class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0) return 0;
        int i = 0, j = n - 1, leftMax = height[0], rightMax = height[n - 1], res = 0;
        while(i <= j){
            if(height[i] <= height[j]){
                if(height[i] >= leftMax) leftMax = height[i];
                else res += leftMax - height[i];
                i++;
            }else{
                if(height[j] >= rightMax) rightMax = height[j];
                else res += rightMax - height[j];
                j--;
            }
        }
        return res;
    }
}