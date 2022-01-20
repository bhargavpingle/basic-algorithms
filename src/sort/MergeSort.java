package sort;

public class MergeSort {

    public static void sort(int[] arr) {
        if (arr.length < 2) return;
        sortHelper(arr, 0, arr.length -1);
    }

    private static void sortHelper(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        sortHelper(arr, left, mid);
        sortHelper(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid+1, rightArr, 0, n2);

        int i=0, j=0, k=left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }
}
