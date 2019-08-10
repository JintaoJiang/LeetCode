class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();
        Map<Integer, Integer> res = new HashMap();
        for(int i : nums1) map.put(i, 1);
        for(int i : nums2){
            if(map.containsKey(i)) res.put(i, 1);
        }
        int[] ans = new int[res.size()];
        int j = 0;
        for(int i : res.keySet()){
            ans[j++] = i;
        }
        return ans;
    }
}