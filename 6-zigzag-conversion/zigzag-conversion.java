class Solution {
    public String convert(String s, int i) {
       StringBuilder ans=new StringBuilder();
        if (i==1 ||s.length()==1 || s.isEmpty()){
            return s;
        }
        List<List<Character>> list=new ArrayList<>();
        int j=0;
        for (int k = 0; k < i; k++) {
             list.add(new ArrayList<>());
        }
        while (j<s.length()){
            for (int k = 0; k < i; k++) {
                if (j<s.length()){
                    char c = s.charAt(j);
                    list.get(k).add(c);
                    j++;
                }
                else{
                    break;
                }
            }
           for (int k = i-2; k > 0; k--) {
                if (j<s.length()){
                    char c = s.charAt(j);
                    list.get(k).add(c);
                    j++;
                }else{
                    break;
                }
            }
        }
        for (List<Character> characters : list) {
            characters.forEach(ans::append);
        }
        return ans.toString(); 
    }
}