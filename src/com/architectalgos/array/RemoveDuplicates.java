package com.architectalgos.array;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appears only once and return the new length.
 *
 * Input: nums = [1,1,2]
 * Output: length = 2, nums = [1,2]
 *
 * Created On : 9/5/23.
 * @author : Architect Algos
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;

        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }

            j++;
        }

        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates duplicates = new RemoveDuplicates();

        int[] nums = {1, 1, 2};

        System.out.println(duplicates.removeDuplicates(nums));
    }
}
