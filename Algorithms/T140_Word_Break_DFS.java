class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String, LinkedList<String>> map = new HashMap();
        return DFS(s, wordDict, map);
    }
    
    private List<String> DFS(String s, List<String> wordDict, Map<String, LinkedList<String>> map){
        if(map.containsKey(s)) return map.get(s);
        
        LinkedList<String> res = new LinkedList();
        if(s.length() == 0){
            res.add("");
            return res;
        }        
        
        for(String word : wordDict){
            if(s.startsWith(word)){
                List<String> suffix = DFS(s.substring(word.length()), wordDict, map);
                for(String str : suffix){
                    res.add(word + (str == "" ? "" : " ") + str);
                }
            }
        }
        
        map.put(s, res);
        return res;
    }
}



    