class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for(String s : strs){
            int[] count = new int[26];
            StringBuilder key = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                count[s.charAt(i) - 'a']++;
            }
            for(int i = 0; i < 26; i++){
                key.append(count[i] + ",");
            }
            if(map.containsKey(key.toString())){
                map.get(key.toString()).add(s);
            }else{
                List<String> list = new LinkedList();
                list.add(s);
                map.put(key.toString(), list);
            }
        }
        List<List<String>> res = new LinkedList();
        for(String s : map.keySet()){
            res.add(map.get(s));
        }
        return res;
    }
}