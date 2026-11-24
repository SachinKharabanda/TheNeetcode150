package arrays_hashing.medium;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length], preArr = new int[nums.length], sufArr = new int[nums.length];
        int prefix = 1, suffix = 1;

        for (int i = 0; i < nums.length; i++) {

            preArr[i] = prefix;
            prefix *= nums[i];

        }

        for (int i = nums.length-1; i >= 0 ; i--) {

            sufArr[i] = suffix;
            suffix *= nums[i];

        }

        for (int i = 0; i < nums.length; i++) {

            res[i] = preArr[i] * sufArr[i];

        }

        return res;

    }

}
