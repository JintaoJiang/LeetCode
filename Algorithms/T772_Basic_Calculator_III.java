class Solution {
    public int calculate(String s) {
        int l1 = 0, l2 = 1;
        int op1 = 1, op2 = 1;
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int num = c - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                l2 = (op2 == 1 ? l2 * num : l2 / num);
            }else if(c == '('){
                //store state
                stack.push(l1); stack.push(op1);
                stack.push(l2); stack.push(op2);
                l1 = 0; l2 = 1;
                op1 = 1; op2 = 1;
            }else if(c == ')'){
                int cur = l1 + l2 * op1;
                //restore state
                op2 = stack.pop(); l2 = stack.pop();
                op1 = stack.pop(); l1 = stack.pop();
                //take effect
                l2 = (op2 == 1 ? l2 * cur : l2 / cur);
            }else if(c == '*' || c == '/'){
                op2 = c == '*' ? 1 : -1;
            }else if(c == '+' || c == '-'){
                if (c == '-' && (i == 0 || s.charAt(i - 1) == '(')) {
                    op1 = -1;
                    continue;
                }
                //take effect
                l1 = l1 + l2 * op1;
                op1 = c == '+' ? 1 : -1;
                l2 = 1; op2 = 1;
            }
        }
        return l1 + l2 * op1;
    }
}