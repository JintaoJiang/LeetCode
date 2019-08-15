class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        int count = 0, i = 0, len = Integer.MAX_VALUE, start = 0;
        for(char c : t.toCharArray()) map[c]--;
        for(int j = 0; j < s.length(); j++){
            if(++map[s.charAt(j)] <= 0) count++; 
            while(count == t.length()){
                if(j - i + 1 < len){
                    len = j - i + 1;
                    start = i;
                }
                if(--map[s.charAt(i)] < 0) count--;
                i++;
            }
        }
        if(len == Integer.MAX_VALUE) return "";
        return s.substring(start, start + len);
    }
}