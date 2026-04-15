class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        while(true) {
            int sum = 0;
            while (n != 0) {
                int rem = n % 10;
                sum += (int) Math.pow(rem,2);
                n /= 10;
            }
            if (sum == 1) {
                return true;
            } else if (set.contains(sum)) {
                break;
            } else {
                set.add(sum);
                n = sum;
            }
        }
        return false;
    }
}