class Solution {
    public int longestOnes(int[] arr, int k) {
        int i=0,j=0;
         
        int n=arr.length;
         
        int zeros=0;
         
        
        while(j<n){
            
            if(arr[j]==0){
               zeros++;  
            }

            if(zeros>k){
                if(arr[i]==0){
                    zeros--;
                }
                i++;
            }
            j++;
        }
        return n-i;
    }
}