class Solution {
    public int reverse(int x) {
        if(x == 0) return 0;
        String data = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        if(data.charAt(0) == '-'){
            sb.append(data.charAt(0));
            data = data.substring(1);
        }
        for(int i = data.length() - 1; i >= 0; i--){  
            if(data.charAt(i) == '0' && sb.length() == 0) continue;
            sb.append(data.charAt(i));
        }            
        long temp = Long.valueOf(sb.toString());
        if(temp > Math.pow(2, 31) - 1 || temp < -Math.pow(2, 31)) return 0;
        return Integer.valueOf(sb.toString());
    }
}
