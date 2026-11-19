class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character,String> map=getMap();
        int idx=0;
        List<String> ans=new ArrayList<>();
        String temp=new String();
         solve(idx,digits,temp,ans,map);
        // System.out.println(ans.stream().map(StringBuilder::toString).toList());
       return ans;
    }

    private static void solve(int idx, String digits,
                              String temp,
                              List<String> ans,
                              Map<Character,String> map) {
        if (idx==digits.length()){
            ans.add(temp);
            return;
        }
         
        for (char c:map.get(digits.charAt(idx)).toCharArray()) {
            String s=new String(temp);
            s+=c;
            solve(idx+1,digits,s,ans,map);
         }
    }
    public Map<Character,String> getMap(){
        Map<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        return map;
    }
}