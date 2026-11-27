package arrays_hashing.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {


        Map<Integer, Integer> linkedMap = new HashMap<>();
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            linkedMap.put(nums[i], null);
        }

        for (Map.Entry<Integer, Integer> x : linkedMap.entrySet()) {

            int curr = x.getKey();
            int next = curr + 1;

            if (linkedMap.containsKey(next)) {
                linkedMap.put(curr, next);
            }

        }

        for (Map.Entry<Integer, Integer> x : linkedMap.entrySet()) {

            if (!linkedMap.containsKey(x.getKey() - 1)) {

                int currKey = x.getKey();
                int seqTotal = 0;
                Set<Integer> keys = linkedMap.keySet();

                while (keys.contains(currKey)) {
                    seqTotal++;
                    currKey++;
                }

                if (seqTotal > total) {total = seqTotal;}

            }

        }

        return total;


    }

}
