class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=Integer.MIN_VALUE;
        int n=s.length();
        int i=0,j=0;
        int[] count =new int[256];
        while (j<n){
            int jndex=s.charAt(j);
            count[jndex]++;
            if (count[jndex]==1){
                max=Math.max(max,j-i+1);
            }
            else {
                while (i<= j && count[jndex]>1){
                    int index=s.charAt(i);
                    count[index]--;
                    i++;
                }
            }
            j++;
        }
        return max==Integer.MIN_VALUE?0:max;
    }
}