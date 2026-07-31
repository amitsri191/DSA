class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        // CountOfRangeSum.lower = lower;
        //     CountOfRangeSum.upper = upper;

            // Step 1: Generate prefix sum array using 'long' to prevent overflow
            long[] prefixSums = new long[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                prefixSums[i + 1] = prefixSums[i] + nums[i];
            }

            // Step 2: Run modified merge sort on the prefix array
            return mergeSort(prefixSums, 0, prefixSums.length - 1,lower,upper);
        }

        private static int mergeSort(long[] S, int left, int right,int lower,int upper) {
            if (left >= right) {
                return 0;
            }

            int mid = left + (right - left) / 2;

            // Count pairs within the left half and right half independently
            int count = mergeSort(S, left, mid,lower,upper) + mergeSort(S, mid + 1, right,lower,upper);

            // Step 3: Count cross-half pairs using two pointers
//            int low = left;
            int low=mid+1;
//            int high = left;
            int high=mid+1;

//            for (int j = mid + 1; j <= right; j++) {
            for (int j =left; j <= mid; j++) {
//                while (low <= mid && S[low] < S[j] - upper) {
//                    low++;
//                }
                while (low <= right && S[low] - S[j] < lower) {
                    low++;
                }
                while (high <= right && S[high] - S[j] <= upper) {
                    high++;
                }
                count += (high - low);
            }

            // Step 4: Standard In-Place Merge Step
            merge(S, left, mid, right);

            return count;
        }

        private static void merge(long[] S, int left, int mid, int right) {
            long[] cache = new long[right - left + 1];
            int i = left;
            int j = mid + 1;
            int k = 0;

            while (i <= mid && j <= right) {
                if (S[i] <= S[j]) {
                    cache[k++] = S[i++];
                } else {
                    cache[k++] = S[j++];
                }
            }

            while (i <= mid) {
                cache[k++] = S[i++];
            }
            while (j <= right) {
                cache[k++] = S[j++];
            }

            System.arraycopy(cache, 0, S, left, cache.length);
        }
    
}