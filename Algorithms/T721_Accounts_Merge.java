class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSet dset = new DSet();
        Map<String, String> ownermap = new HashMap();
        for(List<String> list : accounts){
            String name = list.get(0);
            for(int i = 1; i < list.size(); i++){
                dset.union(list.get(i), list.get(1));
                ownermap.put(list.get(i), name);
            }
        }
        Map<String, TreeSet<String>> resultmap = new HashMap();
        for(List<String> list : accounts){
            String root = dset.find(list.get(1));
            TreeSet<String> set = resultmap.getOrDefault(root, new TreeSet());
            for(int i = 1; i < list.size(); i++){
                if(!set.contains(list.get(i))) set.add(list.get(i));
            }
            resultmap.put(root, set);
        }
        List<List<String>> res = new LinkedList();
        for(String key : resultmap.keySet()){
            List<String> temp = new LinkedList(resultmap.get(key));
            temp.add(0, ownermap.get(key));
            res.add(temp);
        }
        return res;
    }
}

class DSet{
    Map<String, String> map = new HashMap();
    
    public String find(String s){
        if(!map.containsKey(s)){
            map.put(s, s);
            return s;
        }
        if(map.get(s).equals(s)) return s;
        map.put(s, find(map.get(s)));
        return map.get(s);
    }
    
    public void union(String s1, String s2){
        String ps1 = find(s1), ps2 = find(s2);
        if(ps1 == ps2) return;
        map.put(ps2, ps1);
    }
    
}