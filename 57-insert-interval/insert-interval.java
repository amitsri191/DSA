class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list=new ArrayList<>(Arrays.asList(intervals));
        list.add(newInterval);
        boolean mergedAny;

        do{
            mergedAny=false;
            int n=list.size();
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    int[] curr=list.get(i);
                    int[] next=list.get(j);
                    if (Math.max(curr[0],next[0])<=Math.min(curr[1],next[1])){
                        curr[0]=Math.min(curr[0],next[0]);
                        curr[1]=Math.max(curr[1],next[1]);
                        list.remove(j);
                        mergedAny=true;
                        break;
                    }
                }
                if (mergedAny) break;
                }
            }while (mergedAny);

        int[][] ans=list.toArray(new int[list.size()][]);
        Arrays.sort(ans,Comparator.comparingInt(a->a[0]));
        return ans;
    }
}