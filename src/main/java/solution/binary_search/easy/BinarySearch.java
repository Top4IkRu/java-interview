package solution.binary_search.easy;

public class BinarySearch {

    /**
     * Recursion
     */
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int t, int l, int r) {
        if (l > r) return -1;
        if (l == r) return nums[l] == t ? l : -1;
        int m = l + (r - l) / 2;
        if (nums[m] == t) return m;
        if (nums[m] > t) return binarySearch(nums, t, l, m - 1);
        return binarySearch(nums, t, m + 1, r);
    }

    public int search_2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }

        return -1;
    }
}
