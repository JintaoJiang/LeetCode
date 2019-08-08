class Solution {
    public boolean canJump(int[] nums) {
        int maxDist = 0;
        for(int i = 0; i < nums.length; i++){
            if(maxDist < i) return false;
            maxDist = Math.max(maxDist, i + nums[i]);
        }
        return true;
    }
}