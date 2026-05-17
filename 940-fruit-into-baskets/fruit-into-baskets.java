class Solution {
    public int totalFruit(int[] fruits) {
        int max=Integer.MIN_VALUE;
        int k=2;
        int high= Arrays.stream(fruits).max().getAsInt();
        int[] count=new int[high+1];
        int i=0,j=0;
        int uniChar=0;
         
        while (j< fruits.length){
            if (count[fruits[j]]==0){
                uniChar++;
                count[fruits[j]]++;
            }else {
                count[fruits[j]]++;
            }
            if (uniChar<=k){
               max=Math.max(max,j-i+1);
            } else {
                while (i<j && uniChar>k){
                    count[fruits[i]]--;
                    if (count[fruits[i]]==0){
                        uniChar--;
                    }
                    i++;
                }
            }
            j++;
        }
        return max==Integer.MIN_VALUE?0:max;
    }
}