package arrays_hashing.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int search = target - nums[i];

            if (map.containsKey(search) && i != map.get(search)) {
                return new int[] {map.get(search), i};
            }

            map.put(nums[i], i);

        }

        return null;

    }

}
