class Solution {
    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                lo++;
                hi++;
            }else if(s.charAt(i) == ')'){
                lo--;
                hi--;
                if(hi < 0) return false;
                if(lo < 0) lo = 0;
            }else{
                lo--;
                hi++;
                if(lo < 0) lo = 0;
            }
        }
        return lo == 0;
    }
}