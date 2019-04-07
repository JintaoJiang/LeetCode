class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        int denom = numRows * 2 - 2;
        if(denom == 0) denom = 1;
        for(int i = 0; i < numRows; i++){
            sbs[i] = new StringBuilder();
        }
        for(int i = 0; i < s.length(); i++){
            int index = i % denom;
            index = index > denom / 2 ? denom - index : index;
            StringBuilder sb = sbs[index];         
            sb.append(s.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            res.append(sbs[i].toString());
        }
        return res.toString();
    }
}
