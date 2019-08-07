class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '('){
                stack.push(0);
            }else{
                int num = 0;
                while(stack.peek() != 0) num += stack.pop();
                stack.pop();
                if(num == 0){
                    stack.push(1);
                }else{
                    stack.push(2 * num);
                }
            }
        }
        int res = 0;
        while(!stack.isEmpty()) res += stack.pop();
        return res;
    }
}