package arrays_hashing.medium;

import java.util.*;

public class KFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : nums) {
            if (!map.containsKey(x)) {
                map.put(x, 1);
            } else {
                int y = map.get(x);
                y++;
                map.put(x, y);
            }
        }

        int maxFreq = Collections.max(map.values()) + 1;
        List<Integer>[] frequencyList = new List[maxFreq];

        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            int pos = x.getValue();
            int val = x.getKey();

            if (frequencyList[pos] == null) {
                List<Integer> addList = new ArrayList<>();
                addList.add(val);
                frequencyList[pos] = addList;
            } else {
                frequencyList[pos].add(val);
            }



        }

        int counter = 0;
        int pos = frequencyList.length - 1;

        while (counter < k) {


            if (frequencyList[pos] != null) {
                if (frequencyList[pos].size() > 1) {

                    for (int i = 0; i < frequencyList[pos].size(); i++) {

                        if (counter >= k) {
                            break;
                        }

                        res[counter] = frequencyList[pos].get(i);
                        counter++;

                    }

                }
                else {
                    res[counter] = frequencyList[pos].getFirst();
                    counter++;
                }

            }

            pos--;

        }

        return res;

    }


}
