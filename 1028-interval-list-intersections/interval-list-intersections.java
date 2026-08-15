class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int[][] arr=new int[firstList.length+secondList.length+1][];
        if (firstList.length==0 || secondList.length==0){
            return new int[][] {};
        }
        int count=0;
        for (int i = 0; i < firstList.length; i++) {
            for (int j = 0; j < secondList.length; j++) {
                int[] newArr=new int[2];
                if (Math.max(firstList[i][0],secondList[j][0])<=Math.min(firstList[i][1],secondList[j][1])){
                    newArr[0]=(Math.max(firstList[i][0],secondList[j][0]));
                    newArr[1]=(Math.min(firstList[i][1],secondList[j][1]));
                    arr[count++]=newArr;

                }
            }
        }
        return Arrays.copyOf(arr,count);
    }
}