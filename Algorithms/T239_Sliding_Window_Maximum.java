class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return new int[0];
        int[] res = new int[n - k + 1];
        Deque<Integer> q = new LinkedList();
        for(int i = 0; i < n; i++){
            while(!q.isEmpty() && q.peekFirst() <= i - k) q.pollFirst();
            while(!q.isEmpty() && nums[i] >= nums[q.peekLast()]) q.pollLast();
            q.addLast(i);
            if(i >= k - 1) res[i - k + 1] = nums[q.peekFirst()];
        }
        return res;
    }
}