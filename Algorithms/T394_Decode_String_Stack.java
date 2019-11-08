class Solution {    
    public String decodeString(String s) {
        Stack<String> numStack = new Stack();
        Stack<StringBuilder> sbStack = new Stack();
        StringBuilder sb = new StringBuilder();
        String num = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            System.out.println(num);
            if(Character.isDigit(c)){
                num += c + "";
            }else if(c == '['){
                sbStack.push(sb);
                numStack.push(num);
                sb = new StringBuilder(); 
                num = "";
            }else if(c == ']'){
                StringBuilder temp = sb;
                sb = sbStack.pop();
                num = numStack.pop();
                for(int k = Integer.valueOf(num); k > 0; k--){
                    sb.append(temp);
                }
                num = "";
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}