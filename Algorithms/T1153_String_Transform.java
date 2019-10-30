class Solution {
    public boolean canConvert(String str1, String str2) {
        if(str1.equals(str2)) return true;
        int[] map = new int[26];
        Arrays.fill(map, -1);
        for(int i = 0; i < str1.length(); i++){
            int c1 = str1.charAt(i) - 'a', c2 = str2.charAt(i) - 'a';
            if(map[c1] != -1 && map[c1] != c2) return false;
            map[c1] = c2;
        }
        Set<Integer> set = new HashSet();
        for(int i = 0; i < 26; i++){
            if(map[i] != -1) set.add(map[i]);
        }
        return set.size() < 26;
    }
}