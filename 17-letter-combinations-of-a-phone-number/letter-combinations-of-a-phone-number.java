class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character,String> map=new HashMap<>();
        String two="abc";
        String three="def";
        String four="ghi";
        String five="jkl";
        String six="mno";
        String seven="pqrs";
        String eight="tuv";
        String nine="wxyz";
        map.put('2',two);
        map.put('3',three);
        map.put('4',four);
        map.put('5',five);
        map.put('6',six);
        map.put('7',seven);
        map.put('8',eight);
        map.put('9',nine);
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
}