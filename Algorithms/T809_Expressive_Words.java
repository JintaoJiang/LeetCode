class Solution {
    public int expressiveWords(String S, String[] words) {
        int count = 0;
        for(String word : words){
            int i = 0, j = 0;
            char c1 = S.charAt(0), c2 = word.charAt(0);
            boolean ok = true;
            while(i < S.length() || j < word.length()){
                int len1 = 0, len2 = 0;
                for(; i < S.length(); i++){
                    if(S.charAt(i) != c1) break;
                    len1++;
                }
                for(; j < word.length(); j++){
                    if(word.charAt(j) != c2) break;
                    len2++;
                }
                if(c1 != c2 || (len1 < len2) || (len1 > len2 && len1 < 3)){
                    ok = false;
                    break;
                }
                if(i < S.length()) c1 = S.charAt(i);
                if(j < word.length()) c2 = word.charAt(j);
            }
            if(ok) count++;
        }
        return count;
    }
}