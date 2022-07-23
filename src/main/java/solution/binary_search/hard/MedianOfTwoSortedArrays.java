package solution.binary_search.hard;

/**
 * @see <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/">Task 4</a>
 */
// TODO check again, spend too much time
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) return 0;

        if (nums1.length == 0) {
            int n = nums2.length;
            return nums2[(n - 1) / 2] * 0.5 + nums2[n / 2] * 0.5;
        }

        if (nums2.length == 0) {
            int n = nums1.length;
            return nums1[(n - 1) / 2] * 0.5 + nums1[n / 2] * 0.5;
        }

        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        // choose shorter to binary search
        int n = nums1.length;
        int m = nums2.length;
        int left = 0;
        int right = n;

        // 1,2,3,4
        // 2,5,7,8,10
        while (left < right) {
            int i = (left + right) / 2;
            int j = ((n + m) / 2) - i - 1;

            if (nums1[i] < nums2[j]) {
                left = i + 1;
            } else {
                right = i;
            }
        }

        int first = left;
        int second = (n + m) / 2 - left;

        int shorterLeft = first == 0 ? Integer.MIN_VALUE : nums1[first - 1];
        int shorterRight = first == n ? Integer.MAX_VALUE : nums1[first];

        int longerLeft = second == 0 ? Integer.MIN_VALUE : nums2[second - 1];
        int longerRight = second == m ? Integer.MAX_VALUE : nums2[second];

        if ((n + m) % 2 == 1) {
            return Math.min(shorterRight, longerRight);
        } else {
            return Math.max(shorterLeft, longerLeft) * 0.5 + Math.min(shorterRight, longerRight) * 0.5;
        }
    }
}
