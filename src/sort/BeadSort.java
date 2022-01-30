package sort;

public class BeadSort {

    public static void sort(int[] arr) {
        int max = 0;
        for (int num : arr) {
            if (num < 0) throw new IllegalArgumentException("Bead sort supports non-negative integers only");
            max = Math.max(max, num);
        }

        char[][] beads = new char[arr.length][max];

        // Place beads
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i]; j++)
                beads[i][j] = '1';

        // Gravity
        for (int j = 0; j < max; j++) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += beads[i][j] == '1' ? 1 : 0;
                beads[i][j] = 0;
            }
            for (int i = arr.length - sum; i < arr.length; i++)
                beads[i][j] = '1';
        }

        // Read out result
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < max; j++) {
                if (beads[i][j] == '1') count++;
            }
            arr[i] = count;
        }
    }
}
