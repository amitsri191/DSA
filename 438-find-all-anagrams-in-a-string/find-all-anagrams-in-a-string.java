class Solution {
    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> list=new ArrayList<>();
        int[] arr1=new int[26];
        int[] arr2=new int[26];
        if (s.length()==0 || t.length()==0 || s.length()<t.length()) return list;
        for (int i = 0; i < t.length(); i++) {
            arr1[t.charAt(i)-'a']++;
            arr2[s.charAt(i)-'a']++;
        }
        if (isMatch(arr1,arr2)) list.add(0);
        for (int i = 1; i <=s.length()-t.length() ; i++) {
            arr2[s.charAt(i-1)-'a']--;
            arr2[s.charAt(i+t.length()-1)-'a']++;
            if (isMatch(arr1,arr2)) list.add(i);
        }
        return list;
    }

    private static boolean isMatch(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i]!=arr2[i]) return false;
        }
        return true;
    }
    
}