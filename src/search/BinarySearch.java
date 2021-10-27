package search;

public class BinarySearch {
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Target found at mid
            }

            if (arr[mid] < target) {
                left = mid + 1; // Discard the left half
            } else {
                right = mid - 1; // Discard the right half
            }
        }

        return -1; // Return -1 if target is not found
    }
}
