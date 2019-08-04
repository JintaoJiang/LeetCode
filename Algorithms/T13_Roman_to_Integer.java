class Solution {
    static Map<Character, Integer> map = new HashMap(){
        {
            put('I', 1); put('V', 5); put('X', 10); put('L', 50);
            put('C', 100); put('D', 500); put('M', 1000);
        }
    };
    
    public int romanToInt(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int sum = map.get(s.charAt(n - 1));
        for(int i = n - 2; i >= 0; i--){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) sum -= map.get(s.charAt(i));
            else sum += map.get(s.charAt(i));
        }
        return sum;
    }
}