class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int j=0;
        int[] ps=new int[nums.length];
        int n=nums.length;
        int result=Integer.MAX_VALUE;
        Deque<Integer> deque=new ArrayDeque<>();
        while(j<n){
            if (j==0){
                ps[j]=nums[j];
            }else {
                ps[j]=nums[j]+ps[j-1];
            }

            if (j<n && ps[j]>=k){
                result=Math.min(result,j+1);
            }

            while (!deque.isEmpty() && ps[j]-ps[deque.peek()]>=k){
                result=Math.min(result,j-(deque.peek()));
                deque.pollFirst();
            }

            while (!deque.isEmpty() && ps[j]<=ps[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(j);
            j++;
        }
        return result==Integer.MAX_VALUE ? -1 : result;
    }
}