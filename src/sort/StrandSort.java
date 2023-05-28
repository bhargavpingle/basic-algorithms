package sort;

import java.util.*;

public class StrandSort {

    public static void sort(List<Integer> input) {
        List<Integer> result = new ArrayList<>();

        while (!input.isEmpty()) {
            List<Integer> strand = new ArrayList<>();
            strand.add(input.remove(0));

            for (Iterator<Integer> it = input.iterator(); it.hasNext(); ) {
                int val = it.next();
                if (val >= strand.get(strand.size() - 1)) {
                    strand.add(val);
                    it.remove();
                }
            }

            result = merge(result, strand);
        }

        input.addAll(result);
    }

    private static List<Integer> merge(List<Integer> a, List<Integer> b) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i) <= b.get(j)) merged.add(a.get(i++));
            else merged.add(b.get(j++));
        }

        while (i < a.size()) merged.add(a.get(i++));
        while (j < b.size()) merged.add(b.get(j++));
        return merged;
    }
}
