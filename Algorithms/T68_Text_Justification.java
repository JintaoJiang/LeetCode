class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList();
        int i = 0;
        while(i < words.length){
            int len = 0, j = i;
            for(; j < words.length; j++){
                if(len + words[j].length() > maxWidth) break;
                len += words[j].length() + 1;
            }
            int num = j - i - 1, spaces = maxWidth - (len - num - 1);
            StringBuilder cur = new StringBuilder();
            if(j == words.length){
                for(int k = 0; k < num; k++){
                    cur.append(words[i + k]);
                    cur.append(" ");
                }
            }else{
                for(int k = 0; k < num; k++){
                    cur.append(words[i + k]);
                    int space = spaces / (num - k);
                    if(space * (num - k) != spaces) space++;
                    spaces -= space;
                    for(int l = 0; l < space; l++){
                        cur.append(" ");
                    }
                }
            }    
            cur.append(words[j - 1]);
            if(cur.length() != maxWidth){
                int n = cur.length();
                for(int l = 0; l < maxWidth - n; l++){
                    cur.append(" ");
                }
            }
            res.add(cur.toString());
            i = j;
        }
        return res;
    }
}