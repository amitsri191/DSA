class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int k,tc=0;
        int max=Integer.MIN_VALUE;
         String str1=oddSubstring(s);
         String str2=evenSubstring(s);
        return str1.length()>str2.length()? str1 : str2;
    }

    public static String evenSubstring(String s){
        int n=s.length();
        int tc = 0, max=Integer.MIN_VALUE;
        double k=0.5;
        for (double i = 0.5; i < n; i++) {
            k=0.5;
            while (i-k>=0 && i+k<n && s.charAt((int) (i-k))==s.charAt((int) (i+k))){
                k++;
            }
            k--;
            if (max< (i+k)-(i-k)+1){
                tc= (int) (i-k);
                max= (int) ((i+k)-(i-k)+1);
            }
        }
        return s.substring(tc,tc+max);
    }

    public static String oddSubstring(String s){
        int n=s.length();
        int tc=0,max=Integer.MIN_VALUE;
        int k=0;
        for (int i = 0; i < n; i++) {
            k=0;
            while (i-k>=0 && i+k<n && s.charAt((i-k))==s.charAt( (i+k))){
                k++;
            }
            k--;
            if (max< (i+k)-(i-k)+1){
                tc= (i-k);
                max=  ((i+k)-(i-k)+1);
            }
        }
        return s.substring(tc,tc+max);
    }
}