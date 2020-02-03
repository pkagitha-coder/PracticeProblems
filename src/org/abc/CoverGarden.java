package org.abc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CoverGarden {

    public static void main(String[] args) {
        assert (fountainActivation(Arrays.asList(0, 0, 0, 3, 0, 0, 2, 0, 0)) == 2);
        assert (fountainActivation(Arrays.asList(3, 0, 2, 0, 1, 0)) == 2);
        assert (fountainActivation(Arrays.asList(3, 0, 1, 0, 1, 0)) == 2);
        //assert (fountainActivation(Arrays.asList(3, 0, 1, 0, 0, 1)) == 2);
        assert (fountainActivation(Arrays.asList(2, 0, 2, 0, 1, 0)) == 2);
        assert (fountainActivation(Arrays.asList(2, 0, 0, 0, 0)) == 3);
        //assert (fountainActivation(Arrays.asList(0, 0, 0, 0, 0)) == 5);
        assert (fountainActivation(Arrays.asList(1, 2, 1)) == 1);
        assert (fountainActivation(Arrays.asList(0, 1, 0)) == 1);

        System.out.println(fountainActivation(Arrays.asList(3, 0, 1, 0, 0, 1)));
        System.out.println(fountainActivation(Arrays.asList(0,0,0,0,0)));

        System.out.println("All tests passed");

    }

    public static int fountainActivation(List<Integer> locations) {
        if (locations == null) {
            return 0;
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();

        int n = locations.size();
        for (int i = 0; i < n; i++) {
            if (locations.get(i) != 0) {
                int start = Math.max((i + 1) - locations.get(i), 1);
                int end = Math.min((i + 1) + locations.get(i), n);

                Set<Integer> set = map.get(start);
                if (set == null) {
                    set = new HashSet<>();
                    map.put(start,set);
                }
                set.add(end);

                set = map.get(i+1);
                if(set == null) {
                    set = new HashSet<>();
                    map.put(i+1,set);
                }
                set.add(end);
            }
        }

        return findMin(1, n, map);
    }

    private static int findMin(int s, int d, Map<Integer, Set<Integer>> map) {
        if (s == d) {
            return 0;
        }
        Set<Integer> set = map.get(s);
        if (set == null) {
            return 1 + findMin(s + 1, d, map);
        }
        if (set.contains(d)) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        for (Integer i : set) {
            min = Math.min(min, findMin(i, d, map));
        }

        return 1 + min;
    }

}
