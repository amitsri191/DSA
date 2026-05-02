class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                continue;
            }
             
            boolean isPos=nums[i]>0;
            int slow=i;
             int fast=i;
        do{
            slow=nextIndx(nums,slow);
            fast=nextIndx(nums,fast);
            if(isPos){
                if(nums[fast]<0){
                    break;
                }
            }else{
                if(nums[fast]>0){
                    break;
                }
            }
            fast=nextIndx(nums,fast);
            if(isPos){
                if(nums[fast]<0){
                    break;
                }
            }else{
                if(nums[fast]>0){
                    break;
                }
            }
            if(slow==fast){
                if(slow!=nextIndx(nums,slow)){
                    return true;
                }
            }
        }while(slow!=fast);
        int curr=i;
        if (isPos){
                while (nums[curr]>0){
                    int next=nextIndx(nums,curr);
                    nums[curr]=0;
                    curr=next;
                }
            }else {
                while (nums[curr]<0){
                    int next=nextIndx(nums,curr);
                    nums[curr]=0;
                    curr=next;
                }
            }
        }
        return false;
    }

    public static int nextIndx(int[] nums,int curr){
        int next=curr;
        int seq=nums[curr];
        if(seq>0){
            int mod=seq%nums.length;
            next= (mod+next)%nums.length;
        }else{
            int mod = seq % nums.length;
            int forward = (mod + nums.length);
            next=(forward+next)%nums.length;
        }
        return next;
    }
}