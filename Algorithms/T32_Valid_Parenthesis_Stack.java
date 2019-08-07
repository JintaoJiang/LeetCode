class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length(), res = 0;
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}