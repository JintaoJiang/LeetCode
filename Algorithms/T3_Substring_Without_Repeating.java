class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int lo = 0, res = 0;
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(map[arr[i]] == 0) res = Math.max(res, i - lo + 1);
            while(map[arr[i]] > 0){
                map[arr[lo++]]--;
            }
            map[arr[i]]++;
        }
        return res;
    }
}