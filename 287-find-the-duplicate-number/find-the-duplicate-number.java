class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int low=0;
        int high=1;
        while(nums[low]!=nums[high]){
             low++;
             high++;
        }
        return nums[low];
    }
}