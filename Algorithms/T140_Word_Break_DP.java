class Solution {
	public List<String> wordBreak(String s, List<String> wordDict) {
        List<Integer>[] dp = new LinkedList[s.length()];
        for(int i = 0; i < s.length(); i++){
            List<Integer> curr = new LinkedList();
            dp[i] = curr;
            for(int j = i; j >= 0; j--){
                String check = s.substring(j, i + 1);
                if(wordDict.indexOf(check) == -1) continue;
                if(j == 0){
                    curr.add(-1); 
                }else{
                    if(dp[j - 1].size() != 0) curr.add(j - 1);
                }                
            }
        }
        return find(dp, s.length() - 1, s);
    }

    private List<String> find(List<Integer>[] dp, int curr, String s){
        List<String> res = new LinkedList();
        for(int index : dp[curr]){
            if(index == -1){
                res.add(s.substring(0, curr + 1));
            }else{
                List<String> list = find(dp, index, s);
                for(String prev : list){
                    String addOn = prev + " " + s.substring(index + 1, curr + 1);
                    res.add(addOn);
                }
            }            
        }
        return res;
    }
}