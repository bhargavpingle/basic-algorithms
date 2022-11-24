package sort;

import java.util.concurrent.CountDownLatch;

public class SleepSort {

    public static void sort(int[] arr) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(arr.length);

        for (int num : arr) {
            new Thread(() -> {
                try {
                    Thread.sleep(num * 10L); // 10ms per unit
                    System.out.print(num + " ");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            }).start();
        }

        latch.await(); // Wait for all threads to finish
        System.out.println();
    }
}
