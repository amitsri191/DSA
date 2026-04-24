class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int mindifference=Integer.MAX_VALUE,result=0;
        for(int i=0;i<nums.length-2;i++){
            int j=i+1,k=nums.length-1;
            while(j<k){
                int total=nums[i]+nums[j]+nums[k];
                int minvalue = Math.abs(total-target); 
                if(mindifference>minvalue){
                    mindifference=minvalue;
                    result=total;
                }
                if(total==target){
                    return total;
                }else if(total>target){
                    k--;
                }else{
                    j++;
                }
                 
            }
             
        }
        return result;
    }
}