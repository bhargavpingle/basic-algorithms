package sort;

import java.util.*;

public class PigeonholeSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int min = Arrays.stream(arr).min().orElse(0);
        int max = Arrays.stream(arr).max().orElse(0);
        int range = max - min + 1;

        List<List<Integer>> holes = new ArrayList<>(range);
        for (int i = 0; i < range; i++) holes.add(new ArrayList<>());

        for (int num : arr) holes.get(num - min).add(num);

        int index = 0;
        for (List<Integer> hole : holes)
            for (int num : hole)
                arr[index++] = num;
    }
}
