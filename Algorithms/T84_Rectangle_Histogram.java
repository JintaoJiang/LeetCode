class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 0) return 0;
        Stack<int[]> stack = new Stack();
        int res = 0;
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && stack.peek()[0] > heights[i]){
                int[] top = stack.pop();
                int width = 0;
                if(stack.isEmpty()) width = i;
                else width = i - stack.peek()[1] - 1;
                res = Math.max(res, top[0] * width);
            }    
            stack.push(new int[]{heights[i], i});            
        }
        while(!stack.isEmpty()){
            int[] top = stack.pop();
            int width = 0;
            if(stack.isEmpty()) width = n;
            else width = n - stack.peek()[1] - 1;
            res = Math.max(res, top[0] * width);
        }
        return res;
    }
}