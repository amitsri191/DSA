class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list=new ArrayList<>(Arrays.asList(intervals));
         list.add(newInterval);
        list.sort(Comparator.comparingInt(a -> a[0]));
        List<int[]> list2=new ArrayList<>();
        int[] curr= list.get(0);
        list2.add(curr);
        for (int i = 1; i < list.size(); i++) {
            int[] next=list.get(i);
            if (curr[0]<=next[0] && curr[1]>=next[0]){
                curr[0]=Math.min(curr[0],next[0]);
                curr[1]=Math.max(curr[1],next[1]);
            }else{
                curr=next;
                list2.add(next);
            }
        }
        return list2.toArray(new int[list2.size()][]);
    }
}