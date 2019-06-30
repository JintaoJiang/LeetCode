class Solution {
    int m = 0, n = 0;
    Set<String> res = new HashSet();
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String s : words){
            trie.insert(s);
        }
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(trie.children[board[i][j] - 'a'] != null){
                    find(trie, board, i, j, new boolean[m][n], "");
                }
            }
        }
        return new ArrayList(res);
    }
    
    private void find(Trie trie, char[][] board, int i, int j, boolean[][] mask, String s){
        if(i < 0 || i >= m || j < 0 || j >= n || trie.children[board[i][j] - 'a'] == null || mask[i][j]) return;
        s += String.valueOf(board[i][j]);
        if(trie.children[board[i][j] - 'a'].end && !res.contains(s)) res.add(s);
        mask[i][j] = true;
        find(trie.children[board[i][j] - 'a'], board, i + 1, j, mask, s);
        find(trie.children[board[i][j] - 'a'], board, i - 1, j, mask, s);
        find(trie.children[board[i][j] - 'a'], board, i, j + 1, mask, s);
        find(trie.children[board[i][j] - 'a'], board, i, j - 1, mask, s);
        mask[i][j] = false;
    }
}

class Trie {
    Trie[] children = new Trie[26];
    boolean end = false;
    
    public void insert(String word) {
        Trie cur = this;        
        for(int i = 0; i < word.length(); i++){
            if(cur.children[word.charAt(i) - 'a'] != null){
                cur = cur.children[word.charAt(i) - 'a'];
            }else{
                Trie next = new Trie();
                cur.children[word.charAt(i) - 'a'] = next;
                cur = next;
            }               
        } 
        cur.end = true;
    }
}