class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
		char[] str = s.toCharArray();
		int max = 0;
		for(int round = 1; round <= 26; round++) {
			int[] map = new int[26];
			int letters = 0, valid = 0, left = 0;
			for(int i = 0; i < n; i++) {
				if(map[str[i] - 'a'] == 0) letters++;
				map[str[i] - 'a']++;
				if(map[str[i] - 'a'] == k) valid++;
				while(letters > round) {
					map[str[left] - 'a']--;
					if(map[str[left] - 'a'] == k - 1) valid--;
					if(map[str[left] - 'a'] == 0) letters--;
					left++;
				}
				if(valid == round) max = Math.max(max, i - left + 1);
			}
		}
		
        return max;
    }
}