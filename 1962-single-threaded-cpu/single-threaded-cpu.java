class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] nums=new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            nums[i][0] = tasks[i][0];
            nums[i][1] = tasks[i][1];
            nums[i][2]= i;
        }
        Arrays.sort(nums,(a,b)->Integer.compare(a[0],b[0]));

        int[] newArr=new int[tasks.length];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[1]!=b[1]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[2],b[2]);
        });
        long curr=nums[0][0];
        int i=0,count=0;
        while (i< nums.length || !pq.isEmpty()){
            while(i < nums.length && nums[i][0]<=curr){
                   pq.offer(nums[i]);
                i++;
            }
            int[] del=pq.poll();
            if (del != null) {
                newArr[count++]=del[2];
                curr+=del[1];
            }else{
                curr=nums[i][0];
            }

        }
         
        return newArr;
    }
}