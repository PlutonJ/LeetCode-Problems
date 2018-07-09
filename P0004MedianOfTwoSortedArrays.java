// https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2471/Very-concise-O(log(min(MN)))-iterative-solution-with-detailed-explanation

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1, n2;
        if((n1 = nums1.length) < (n2 = nums2.length)) return findMedianSortedArrays(nums2, nums1);
        int lo = 0, hi = 2 * n2;
        while(lo <= hi) {
            int m2 = (lo + hi) / 2, m1 = n1 + n2 - m2, l1 = (m1 == 0) ? Integer.MIN_VALUE : nums1[(m1 - 1) / 2], l2 = (m2 == 0) ? Integer.MIN_VALUE : nums2[(m2 - 1) / 2], r1 = (m1 == n1 * 2) ? Integer.MAX_VALUE : nums1[m1 / 2], r2 = (m2 == n2 * 2) ? Integer.MAX_VALUE : nums2[m2 / 2];
            if(l1 > r2) lo = m2 + 1;
            else if(l2 > r1) hi = m2 - 1;
            else return (double)(Math.max(l1, l2) + Math.min(r1, r2)) / 2;
        }
        return -1;
    }
}