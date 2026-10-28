class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s ;
        StringBuilder result = new StringBuilder() ;
        int n = s.length() ;
        int cycle = 2 * (numRows - 1) ;
        for(int r = 0 ; r < numRows ; r++){
            for(int j = r ; j < n ; j += cycle){
                 result.append(s.charAt(j)) ;
                 int diag = j + cycle - 2 * r ;
                 if(r != 0 && r != numRows - 1 && diag < n){
                    result.append(s.charAt(diag)) ;
                 }
            }
        }
        return result.toString() ;
    }
}