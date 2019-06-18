class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < strs[0].length()){
            char c = '0';
            for(int j = 0; j < strs.length; j++){
                String s = strs[j];                
                if(s.length() <= i) return sb.toString();
                if(j == 0){
                    c = s.charAt(i);
                }else{
                    if(c != s.charAt(i)){
                        return sb.toString();
                    }
                }
            }
            sb.append(c);
            i++;
        }
        return sb.toString();
    }
}