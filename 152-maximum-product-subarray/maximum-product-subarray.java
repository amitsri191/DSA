class Solution {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int preffix=1;
        int suffix=1;
        if(nums.length==1) return nums[0];
        for(int i=0;i<nums.length;i++){
            if(preffix==0) preffix=1;
            if(suffix==0) suffix=1;
            preffix*=nums[i];
            suffix*=nums[nums.length-1-i];
            max=Math.max(max,Math.max(preffix,suffix));
        }
        return max;
    }
}