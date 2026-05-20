class Solution {
    public int characterReplacement(String s, int k) {
        int i=0,j=0;
        int max=Integer.MIN_VALUE;
        int length=Integer.MIN_VALUE;
        int maxLen=0;
        int[] count=new int[26];
        if (s.length()<k){
            return 0;
        }
        while (j<s.length()){
            int index=s.charAt(j)-65;
            count[index]++;
            max=Math.max(max,count[index]);
            maxLen=(j-i+1)-max;
            if (maxLen<=k){
                length=Math.max(length,j-i+1);
            }
            else {
                 while (i<=j && maxLen>k){
                     index=s.charAt(i)-65;
                     count[index]--;
                     maxLen--;
                     i++;
                 }
            }
            j++;
        }
        return length==Integer.MIN_VALUE?0:length;
    }
}