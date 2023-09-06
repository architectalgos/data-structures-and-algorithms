package com.architectalgos.array;

/**
 * Created On : 9/5/23.
 *
 * @author : Architect Algos
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Set c1 and c2 to point to the end of their respective arrays.
        int c1 = m - 1;
        int c2 = n - 1;

        // And move c backwards through the array, each time writing
        // the smallest value pointed at by c1 or c2.
        for (int c = m + n - 1; c >= 0; c--) {
            if (c2 < 0) {
                break;
            }
            if (c1 >= 0 && nums1[c1] > nums2[c2]) {
                nums1[c] = nums1[c1--];
            } else {
                nums1[c] = nums2[c2--];
            }
        }
    }

    public static void main(String[] args) {

    }
}
