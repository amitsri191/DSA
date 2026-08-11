class Solution {
    public int[][] merge(int[][] intervals) {
         boolean mergedAny;
        List<int[]> list=new ArrayList<>(Arrays.asList(intervals));
        
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
        return list.toArray(new int[list.size()][]);
    }

    private static int[][] mergeInterval(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> arr=new ArrayList<>();
          int[] currentInterval=intervals[0];
          arr.add(currentInterval);
            for (int[] interval:intervals){
                int currentEnd=currentInterval[1];
                int nextStart=interval[0];
                int nextEnd=interval[1];
                 if ( nextStart<=currentEnd){
                      currentInterval[1]=Math.max(nextEnd,currentEnd);
                }else{
                    currentInterval=interval;
                    arr.add(currentInterval);
                }

            }
        return arr.toArray(new int[arr.size()][]);
    }
}