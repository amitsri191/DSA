class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int curNeg=0,curPos=0;
        int maxPos=Integer.MIN_VALUE,maxNeg=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            curPos+=nums[i];
            curNeg+=nums[i];
            if(curPos>maxPos) maxPos=curPos;
            if(curNeg<maxNeg) maxNeg=curNeg;
            if(curPos<0) curPos=0;
            if(curNeg>0) curNeg=0;
        }
        return Math.max(maxPos,Math.abs(maxNeg));
    }
}