class Solution {
    public int[][] merge(int[][] intervals) {
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