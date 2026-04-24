class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
         
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(arr);
        
        for (int i = 0; i < arr.length-2; i++) {
            int j=i+1,k= arr.length-1;
        while(j<k){
            int val=arr[i]+arr[j]+arr[k];
            if (val==0){
                List<Integer> newlist=new ArrayList<>();
                newlist.add(arr[i]);
                newlist.add(arr[j]);
                newlist.add(arr[k]);
                list.add(newlist);
                while(j<k && arr[k-1]==arr[k]){
                    k--;
                }
            }else if(val<0){
                j++;
                continue;
            }
            k--;
        }
        while(i<arr.length-2 && arr[i]==arr[i+1]){
            i++;
        }
        }
        return   list;
    }
}