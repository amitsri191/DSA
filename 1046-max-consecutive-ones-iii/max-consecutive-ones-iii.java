class Solution {
    public int longestOnes(int[] arr, int k) {
        int i=0,j=0;
        int max=Integer.MIN_VALUE;
        int n=arr.length;
        int maxLen=0;
        int maxSize=Integer.MIN_VALUE;
        int[] count=new int[2];
        while(j<n){
            count[arr[j]]++;
            if(k==0 && arr[j]==1){
                maxSize=Math.max(maxLen,count[1]);
            }
            else if (count[0]<=k){
//                max=Math.max(max,count[arr[j]]);
                maxSize=Math.max(maxSize,(j-i)+1);
            }else{
                while (i<=j && count[0]>k){
                    count[arr[i]]--;
                    i++;

                }
            }
//            maxLen=(j-i+1)-max;
//            if (maxLen>0 && maxLen<=k){
//               maxSize=Math.max(maxSize,j-i+1);
//            }else{
//                count[arr[i]]--;
//                i++;
//            }
//
            j++;
        }
        return maxSize==Integer.MIN_VALUE?0:maxSize;
    }
}