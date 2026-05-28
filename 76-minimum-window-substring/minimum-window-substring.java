class Solution {
    public String minWindow(String s, String t) {
        int i=0,j=0,count=0;
        int min=Integer.MAX_VALUE;
        int startingPoint=-1;

        int minLength =Integer.MAX_VALUE;

        Map<Character,Integer> map=new HashMap<>();
        if(s.length()<t.length() || s.length()==0 || t.length()==0) {return "";}

        for (int k = 0; k < t.length(); k++) {
            char ch=t.charAt(k);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int uniChar=map.size();
        while (j<s.length()){
            char ch=s.charAt(j);
            if (map.containsKey(ch)){
                 map.put(ch, map.get(ch)-1);
                 if (map.get(ch)==0) uniChar--;
            }
            while (uniChar==0) {
                if (j-i+1<minLength){
                    minLength=j-i+1;
                    startingPoint=i;
                }
                ch=s.charAt(i);
                if (map.containsKey(ch)){
                    map.put(ch, map.get(ch)+1);
                    if (map.get(ch)>0){
                        uniChar++;
                    }
                }
                i++;
            }
            j++;
        }
        return startingPoint==-1?"":s.substring(startingPoint,startingPoint+minLength);
    }
}