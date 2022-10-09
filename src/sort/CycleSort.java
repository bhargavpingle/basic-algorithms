package sort;

public class CycleSort {

    public static void sort(int[] arr) {
        int writes = 0;

        for (int cycleStart = 0; cycleStart < arr.length - 1; cycleStart++) {
            int item = arr[cycleStart];
            int pos = cycleStart;

            for (int i = cycleStart + 1; i < arr.length; i++)
                if (arr[i] < item) pos++;

            if (pos == cycleStart) continue;

            while (item == arr[pos]) pos++;
            if (pos != cycleStart) {
                int temp = item;
                item = arr[pos];
                arr[pos] = temp;
                writes++;
            }

            while (pos != cycleStart) {
                pos = cycleStart;
                for (int i = cycleStart + 1; i < arr.length; i++)
                    if (arr[i] < item) pos++;

                while (item == arr[pos]) pos++;

                if (item != arr[pos]) {
                    int temp = item;
                    item = arr[pos];
                    arr[pos] = temp;
                    writes++;
                }
            }
        }

        System.out.println("Cycle Sort completed with " + writes + " writes.");
    }
}
