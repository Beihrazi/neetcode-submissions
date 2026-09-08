class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m =nums1.length, n = nums2.length;
        int total = m+n;
        if(m <= n){
            return bs(nums1, nums2, total);
        }else{
            return bs(nums2, nums1, total);
        }
    }
    //| 1,2
    //3,4

    public double bs(int[] m, int[] n, int total){
        int low = 0, high = m.length;

        while(low<=high){
            int mid = low + (high-low)/2; //the gap between elements
            int half = total/2;

            int partitionB = half-mid; //2

            int leftMaxA = mid == 0 ? Integer.MIN_VALUE : m[mid-1]; // -inf
            int rightMinA = mid == m.length ? Integer.MAX_VALUE : m[mid]; //1

            int leftMaxB = partitionB == 0? Integer.MIN_VALUE : n[partitionB-1]; //4
            int rightMinB = partitionB == n.length ? Integer.MAX_VALUE : n[partitionB]; //+inf

            if(leftMaxA <= rightMinB && leftMaxB <= rightMinA){
                if(total % 2 == 0){
                    return ((Math.max(leftMaxA, leftMaxB) + Math.min(rightMinA, rightMinB))/2.0);
                }else{
                    return (double) Math.min(rightMinA, rightMinB);
                }
            }
            if(leftMaxA > rightMinB){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return 0.0;
    }
}
