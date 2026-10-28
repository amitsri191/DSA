class Solution {
    public String convert(String s, int i) {
        if(i==1){
            return s;
        }
       StringBuilder sb=new StringBuilder();
        for (int j = 0; j < i; j++) {
            int idx=j;
            int deltaSouth=2*(i-1-j);
            int deltaNorth=2*(j);
            boolean goingSouth=true;
            while (idx<s.length()){
                sb.append(s.charAt(idx));
                if (j==0){
                    idx+=deltaSouth;
                } else if (j==i-1) {
                    idx+=deltaNorth;
                }else {
                    if (goingSouth) {
                        idx += deltaSouth;
                    } else {
                        idx += deltaNorth;
                    }
                }
                goingSouth=!goingSouth;
            }
        }
        return sb.toString(); 
    }
}