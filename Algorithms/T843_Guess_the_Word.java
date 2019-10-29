class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> mywordlist = Arrays.asList(wordlist);
        for(int i = 0; i < 10; i++){
            String guess = findBest(mywordlist);
            int ret = master.guess(guess);
            if(ret == 6) break;
            List<String> guesslist = new LinkedList();
            for(String word : mywordlist){
                if(count(word, guess) == ret) guesslist.add(word);
            }
            mywordlist = guesslist;
        }
    }
    
    private String findBest(List<String> mywordlist){
        Map<String, int[]> map = new HashMap();
        for(int i = 0; i < mywordlist.size(); i++){
            map.put(mywordlist.get(i), new int[7]);    
        }
        int min = Integer.MAX_VALUE;
        String res = "";
        for(int i = 0; i < mywordlist.size(); i++){
            int max = 0;
            String cur = mywordlist.get(i);
            int[] match = map.get(cur);
            for(int j = 0; j < mywordlist.size(); j++){
                String comp = mywordlist.get(j);
                match[count(cur, comp)]++;
            }
            for(int j = 0; j < 7; j++) max = Math.max(max, match[j]);
            if(max < min){
                min = max;
                res = cur;
            }
        }
        return res;
    }
    
    private int count(String s1, String s2){
        int res = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(i)){
                res++;
            }
        }
        return res;
    }
}