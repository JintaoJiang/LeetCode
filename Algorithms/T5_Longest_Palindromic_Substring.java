class Solution {
    int lo = 0, len = 0;
    
    public String longestPalindrome(String s) {
        for(int i = 0; i < s.length(); i++){
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        return s.substring(lo, lo + len);
    }
    
    private void extend(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            if(j - i + 1 > len){
                lo = i;
                len = j - i + 1;
            }
            i--;
            j++;
        }
    }
}