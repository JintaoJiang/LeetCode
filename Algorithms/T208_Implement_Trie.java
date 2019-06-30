class Trie {
    Trie[] children = new Trie[26];
    boolean end = false;
    
    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie cur = this; 
        for(int i = 0; i < word.length(); i++){
            Trie next = cur.children[word.charAt(i) - 'a'];
            if(next == null) return false;
            cur = next;
        }
        return cur.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie cur = this; 
        for(int i = 0; i < prefix.length(); i++){
            Trie next = cur.children[prefix.charAt(i) - 'a'];
            if(next == null) return false;
            cur = next;
        }
        return true;
    }
}