class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1) return s;
        int n=s.length();
        int max=Integer.MIN_VALUE;
        String ans=null;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <=n ; j++) {
                boolean res=findPalindrome(s.substring(i,j));
                if (res){
                    if(max<j-i+1){
                        max=j-i+1;
                        ans=s.substring(i,j);
                    }
                }
            }
        }
        return ans;
    }

    public static boolean findPalindrome(String str){
        if (str.length()==1) return true;
        int i=0,j=str.length()-1;
         while (i<j){
             if (str.charAt(i)!= str.charAt(j)) return false;
             else {
                 i++;
                 j--;
             }
         }
         return true;
    }
}