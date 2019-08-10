class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();
        Map<Integer, Integer> res = new HashMap();
        int count = 0;
        for(int i : nums1) map.put(i, map.getOrDefault(i, 0) + 1);
        for(int i : nums2){
            if(map.containsKey(i) && res.getOrDefault(i, 0) < map.get(i)){
                res.put(i, res.getOrDefault(i, 0) + 1);
                count++;
            }
        }
        int[] ans = new int[count];
        int j = 0;
        for(int i : res.keySet()){
            for(int k = res.get(i); k > 0; k--){
                ans[j++] = i;
            }
        }
        return ans;
    }
}