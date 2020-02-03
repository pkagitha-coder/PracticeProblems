package org.abc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreqQueries {

    public static void main(String[] args) {
        Util.printList(freqQuery(Arrays.asList(Arrays.asList(3,4),
                Arrays.asList(2, 1003),
                Arrays.asList(1, 16),
                Arrays.asList(3, 1))));
        Util.printList(freqQuery(Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(3, 2),
                Arrays.asList(1, 4),
                Arrays.asList(1, 5),
                Arrays.asList(1, 5),
                Arrays.asList(1, 4),
                Arrays.asList(3, 2),
                Arrays.asList(2, 4),
                Arrays.asList(3, 2)
        )));
    }

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer,Integer> countFreq = new HashMap<>();
        Map<Integer,Integer> freqMap = new HashMap<>();

        List<Integer> result = new ArrayList<>();
        for(List<Integer> query : queries) {
            Integer queryOper = query.get(0);
            Integer value = query.get(1);
            if(queryOper == 1 ) {
                if(countFreq.containsKey(value)) {
                    Integer oldCount = countFreq.get(value);
                    int newCount = oldCount + 1;

                    countFreq.put(value, newCount);

                    freqMap.put(oldCount,freqMap.get(oldCount) -1);
                    freqMap.put(newCount,freqMap.getOrDefault(newCount,0)+1);
                }else {
                    countFreq.put(value,1);
                    freqMap.put(1,freqMap.getOrDefault(1,0)+1);
                }
            }else if(queryOper == 2) {
                if(countFreq.containsKey(value)) {
                    Integer oldCount = countFreq.get(value);
                    Integer newCount = Math.max(oldCount-1,0);
                    countFreq.put(value, newCount);

                    freqMap.put(oldCount,freqMap.get(oldCount)-1);

                    freqMap.put(newCount,freqMap.getOrDefault(newCount,0)+1);
                }
            }else if(queryOper == 3) {
                if(freqMap.containsKey(value) && freqMap.get(value) > 0) {
                    result.add(1);
                }else {
                    result.add(0);
                }
            }
        }
        return result;
    }
}
