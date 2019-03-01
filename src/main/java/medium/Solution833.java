package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution833 {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        List<int[]> sorted = new ArrayList<>();

        for (int i = 0 ; i < indexes.length; i++)
            sorted.add(new int[]{indexes[i], i});

        Collections.sort(sorted, Comparator.comparing(i -> -i[0]));

        for (int[] ind: sorted) {
            int i = ind[0];
            int j = ind[1];

            String s = sources[j];
            String t = targets[j];

            if (S.substring(i, i + s.length()).equals(s))
                S = S.substring(0, i) + t + S.substring(i + s.length());
        }
        return S;
    }
}
