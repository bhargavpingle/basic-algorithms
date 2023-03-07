package sort;

import java.util.PriorityQueue;

public class TournamentSort {

    public static void sort(int[] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : arr) heap.offer(num);
        for (int i = 0; i < arr.length; i++) arr[i] = heap.poll();
    }
}
