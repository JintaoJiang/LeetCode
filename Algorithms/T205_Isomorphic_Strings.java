class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap();
        Set<Character> set = new HashSet();
        for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if((map.containsKey(c1) && map.get(c1) != c2) || (!map.containsKey(c1) && set.contains(c2)))
                return false;
            map.put(c1, c2);
            set.add(c2);
        }
        return true;
    }
}