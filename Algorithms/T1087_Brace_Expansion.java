class Solution {
    public String[] expand(String S) {
        String[] data = S.split("\\{|\\}");
        List<String> ans = new LinkedList();
        DFS(data, 0, "", ans);
        String[] res = new String[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }
    
    private void DFS(String[] data, int start, String s, List<String> ans){
        if(start == data.length){
            ans.add(s);
            return;
        }
        String[] option = data[start].split(",");
        Arrays.sort(option);
        for(String c : option){
            DFS(data, start + 1, s + c, ans);
        }
    }
}