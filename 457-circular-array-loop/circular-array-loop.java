class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                continue;
            }
            Set<Integer> set=new HashSet<>();
            set.add(i);
            boolean isPos=nums[i]>0;
            int curr=i;
            while(true){
                int next=nextIndx(nums,curr);
                if(isPos){
                    if(nums[next]<0){
                        break;
                    }else{
                        if(set.contains(next)){
                            if(curr!=next){
                                return true;
                            }else{
                                break;
                            }
                        }
                        set.add(next);
                    }
                }else{
                    if(nums[next]>0){
                        break;
                    }else{
                        if(set.contains(next)){
                            if(curr!=next){
                                return true;
                            }else{
                                break;
                            }
                        }
                        set.add(next);
                    }
                }
                curr=next;
            }
            curr=i;
            if(isPos){
                while(nums[curr]>0){
                        int next=nextIndx(nums,curr);
                        nums[curr]=0;
                        curr=next;
                     }
            }else{
                while(nums[curr]<0){
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