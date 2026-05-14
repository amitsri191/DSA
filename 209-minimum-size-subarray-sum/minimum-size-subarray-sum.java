class Solution {
    public int minSubArrayLen(int target, int[] nums) {
    int n = nums.length;
        if (n == 0) return 0;

        int minLen = Integer.MAX_VALUE;
        // Create prefix sum array: sums[i] is sum of nums[0...i-1]
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        // Iterate through each possible starting point
        for (int i = 0; i < n; i++) {
            // We need sums[j] - sums[i] >= target  =>  sums[j] >= target + sums[i]
            int toFind = target + sums[i];

            // Binary search for the first index j where sums[j] >= toFind
            int bound =binarySearch(sums, i + 1, n, toFind);

            if (bound != -1) {
                minLen = Math.min(minLen, bound - i);
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    private static int binarySearch(int[] arr, int left, int right, int key) {
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= key) {
                result = mid; // Potential answer, look further left
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    
}