class Solution {
    public int calculate(String s) {
        char[] data = s.toCharArray();
        int res = 0, sign = 1, num = 0;
        Stack<Integer> stack = new Stack();
        for(char c : data){
            if(c >= '0' && c <= '9'){
                num = num * 10 + (c - '0');
            }else if(c == '('){
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }else if(c == ')'){
                res += sign * num;
                int curSign = stack.pop();
                int lastRes = stack.pop();
                res = lastRes + curSign * res;
                num = 0;
            }else if(c == '+'){
                res += sign * num;
                sign = 1;
                num = 0;
            }else if(c == '-'){
                res += sign * num;
                sign = -1;
                num = 0;
            }
        }
        res += sign * num;
        return res;
    }
}