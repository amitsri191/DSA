class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map= new HashMap<>();
        int sum=0,length=Integer.MIN_VALUE;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) nums[i]=-1;
            sum+=nums[i];
            if(map.containsKey(sum)) length=Math.max(length,i-map.get(sum));
            map.put(sum,map.getOrDefault(sum,i));
        }
        return length==Integer.MIN_VALUE?0:length;
    }
}