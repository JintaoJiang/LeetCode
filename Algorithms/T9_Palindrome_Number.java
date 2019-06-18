class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        Deque<Integer> q = new LinkedList();
        while(x != 0){
            q.addFirst(x % 10);
            x /= 10;
        }
        while(!q.isEmpty()){
            if(q.size() == 1) return true;
            if(q.pollFirst() != q.pollLast()) return false;
        }
        return true;
    }
}