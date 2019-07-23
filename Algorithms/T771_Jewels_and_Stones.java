class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] map = new boolean[52];
        char[] j = J.toCharArray();
        char[] s = S.toCharArray();
        int res = 0;
        for(char c : j){
            if(c >= 'a' && c <= 'z') map[c - 'a'] = true;
            else map[c - 'A' + 26] = true;
        }
        for(char c : s){
            if(c >= 'a' && c <= 'z' && map[c - 'a']) res++;
            if(c >= 'A' && c <= 'Z' && map[c - 'A' + 26]) res++;
        }
        return res;
    }
}