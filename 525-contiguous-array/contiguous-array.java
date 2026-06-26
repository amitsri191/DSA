class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map= new HashMap<>();
        int sum=0,length=0;
        map.put(0,-1);
        // for(int i:nums){
        //     if(i==0) i=-1;
        // }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) nums[i]=-1;
        }
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum)) length=Math.max(length,i-map.get(sum));
            else map.put(sum,i);
        }
        return  length;
    }
}