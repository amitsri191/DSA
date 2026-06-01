class Solution {
    public boolean checkInclusion(String s, String t) {
        int[] arr1=new int[26];
        int[] arr2=new int[26];
        if (s.length()==0 || t.length()==0 || s.length()>t.length()) return false;
        for (int i = 0; i < s.length(); i++) {

            arr1[s.charAt(i)-'a']++;
            arr2[t.charAt(i)-'a']++;
        }
        if (isMatch(arr1,arr2)) return true;

        int totalSize=s.length();

        for (int k = 1; k <= t.length()-s.length(); k++) {
            arr2[t.charAt(k-1)-'a']--;
            arr2[t.charAt(k+s.length()-1)-'a']++;
             if (isMatch(arr1,arr2)) return true;
        }
        return false;
    }

    private static boolean isMatch(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i]!=arr2[i]) return false;
        }
        return true;
    }
}