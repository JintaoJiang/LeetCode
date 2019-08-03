class Solution {
    public int myAtoi(String str) {
        long res = 0, sign = 0;
        for(char c : str.toCharArray()){
            if(Character.isDigit(c)){
                res = res * 10 + (c - '0');
                if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
                    res *= sign;
                    if(res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                    if(res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                }
                if(sign == 0) sign = 1;
            }else if(c == '-' && sign == 0){
                sign = -1;
            }else if(c == '+' && sign == 0){
                sign = 1;
            }else if(c == ' ' && sign == 0){
                continue;
            }else{
                break;
            }
        }
        res *= sign;
        return (int)res;
    }
}