class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList();
        queue.add(beginWord);
        int level = 1;
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0; i < n; i++){
                String word = queue.poll();                
                if(word.equals(endWord)) return level;
                for(Iterator<String> it = wordList.iterator(); it.hasNext();){
                    String s = it.next();
                    if(inDistance(word, s)){
                        queue.add(s);
                        it.remove();                     
                    }
                }
            }
            level++;   
        }
        return 0;
    }
    
    private boolean inDistance(String s1, String s2){
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
                if(count > 1) return false;
            }
        }
        return true;
    }
}
