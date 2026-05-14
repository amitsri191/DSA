class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int i=0, sum=0,min=Integer.MAX_VALUE;
        for (int k = 0; k < arr.length; k++) {
            sum+=arr[k];
            while (k<arr.length && sum>=target){
                min=Math.min(min,k-i+1);
                sum-=arr[i];
                i++;
            }

        }

        return min==Integer.MAX_VALUE?0:min;
    }
}