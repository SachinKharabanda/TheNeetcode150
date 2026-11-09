package binary_search.easy;

import java.util.Arrays;

public class BinarySearch {

    public int search(int[] nums, int target) {

        // Index in the original array where the current slice starts
        int offset = 0;

        while (nums.length > 0) {

            int midPoint = nums.length / 2;

            if (target == nums[midPoint]) {
                return offset + midPoint;
            } else if (target > nums[midPoint]) {
                nums = Arrays.copyOfRange(nums, midPoint + 1, nums.length);
                offset += midPoint + 1;
            } else {
                nums = Arrays.copyOfRange(nums, 0, midPoint);
            }

        }

        return -1;

    }

}
