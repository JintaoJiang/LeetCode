class Solution {
    public int shortestWay(String source, String target) {
        int res = 0;
        for(int i = 0; i < target.length();){
            int temp = i;
            for(int j = 0; j < source.length(); j++){
                if(i == target.length()) break;
                if(source.charAt(j) == target.charAt(i)) i++;
            }
            if(temp == i) return -1;
            res++;
        }
        return res;
    }
}