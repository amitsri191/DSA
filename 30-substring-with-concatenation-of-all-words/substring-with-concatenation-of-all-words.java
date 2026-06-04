class Solution {
    public List<Integer> findSubstring(String s, String[] t) {
        Map<String, Integer> map1 = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        if(s.length()==0 || t.length==0) return ans;
        for (int i = 0; i < t.length; i++) {
            map1.put(t[i], map1.getOrDefault(t[i], 0) + 1);
        }
        int len = t[0].length();
        for (int i = 0; i < len; i++){
             Map<String, Integer> map2 = new HashMap<>();
             int count=0;
            for (int j = i,k=i; j+len <=s.length() ; j+=len) {
                String word=s.substring(j,j+len);
                map2.put(word,map2.getOrDefault(word,0)+1);
                count++;
                if (count==t.length){
                    if (map1.equals(map2)){
                        ans.add(k);
                    }
                    String remove=s.substring(k,k+len);
                    map2.computeIfPresent(remove,(a,b)->(b>1)?b-1:null);
                    count--;
                    k=k+len;
                }
            }
         }
         return ans;
    }
}