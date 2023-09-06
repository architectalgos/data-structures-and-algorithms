package com.architectalgos.array;

/**
 * Created On : 8/27/23.
 *
 * @author : madstuff
 */
class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        // Initialize using the first element.
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];

        // Start with the 2nd element since we already used the first one.
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // If the currentSubarray is negative, throw it away. Else, keep adding to it.
            currentSubarray = Math.max(num, currentSubarray + num);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }

        return maxSubarray;
    }
}