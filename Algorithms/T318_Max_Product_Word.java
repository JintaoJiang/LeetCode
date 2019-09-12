class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] values = new int[n];
        for(int i = 0; i < n; i++){
            for(char c : words[i].toCharArray()){
                values[i] |= 1 << (c - 'a');
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int len = words[i].length() * words[j].length();
                if((values[i] & values[j]) == 0 && len > res) res = len;
            }
        }
        return res;
    }
}