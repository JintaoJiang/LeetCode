class Solution {
    int pos = 0;
    
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        String num = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num += c + "";
            }else if(c == '['){
                String next = decodeString(s.substring(i + 1));
                for(int k = Integer.valueOf(num); k > 0; k--){
                    sb.append(next);
                }
                i += pos + 1;
                num = "";
            }else if(c == ']'){
                pos = i;
                return sb.toString();
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}