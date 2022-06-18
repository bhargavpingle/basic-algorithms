package sort;

import java.util.*;

public class BucketSort {
    public static void sort(float[] arr) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;
        List<List<Float>> buckets = new ArrayList<>(n);

        for (int i = 0; i < n; i++)
            buckets.add(new ArrayList<>());

        for (float value : arr) {
            int bucketIndex = (int)(value * n);
            buckets.get(bucketIndex).add(value);
        }

        for (List<Float> bucket : buckets)
            Collections.sort(bucket);

        int index = 0;
        for (List<Float> bucket : buckets)
            for (float value : bucket)
                arr[index++] = value;
    }
}
