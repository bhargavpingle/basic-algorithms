package search;

public class RecursiveBinarySearch {

    // Existing methods here...

    /**
     * Performs recursive binary search on a sorted array.
     * @param arr Sorted array to search.
     * @param target The target element to find.
     * @param left Left boundary index.
     * @param right Right boundary index.
     * @return Index of the target if found, otherwise -1.
     */
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right);
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }
    }
}
