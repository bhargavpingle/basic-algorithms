package search;

public class RecursiveBinarySearch {

    // Existing linearSearch method here...

    /**
     * Performs iterative binary search on a sorted array.
     * @param arr Sorted array to search.
     * @param target The target element to find.
     * @return Index of the target if found, otherwise -1.
     */
    public static int binarySearchIterative(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
