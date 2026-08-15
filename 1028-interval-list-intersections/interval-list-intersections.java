class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length==0 && secondList.length==0){
            return new int[][]{};
        }
        int i=0,j=0,count=0;
        int[][] arr=new int[firstList.length+ secondList.length+1][];
        while (i< firstList.length && j< secondList.length){
            int[] newArr =new int[2];
            if (Math.max(firstList[i][0],secondList[j][0])<=Math.min(firstList[i][1],secondList[j][1])){
                newArr[0]=(Math.max(firstList[i][0],secondList[j][0]));
                newArr[1]=(Math.min(firstList[i][1],secondList[j][1]));
                arr[count++]=newArr;

            }
            if (secondList[j][1]>=firstList[i][1]){
                i++;
            }else {
                j++;
            }
        }
        return Arrays.copyOf(arr,count);
    }
}