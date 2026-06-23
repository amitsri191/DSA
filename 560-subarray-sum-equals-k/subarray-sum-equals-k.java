class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0,count=0;
//        int[] arr=new int[nums.length+1];
//        arr[0]=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(sum, map.getOrDefault(sum,0)+1);
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            int target=sum-k;

            if (map.containsKey(target)){
                count+=map.get(target);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);

        }
        return count;
    }
}