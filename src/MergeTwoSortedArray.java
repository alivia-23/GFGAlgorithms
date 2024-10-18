import java.util.Arrays;
/**
 * Problem Statement
 * Given two sorted arrays A[] and B[] of size N and M. The task is to merge both the arrays into a single array in non-decreasing order.
 * Examples:
 * Input: A[] =[3, 9, 10, 18, 23], B[] = [5, 12, 15, 20, 21, 25]
 * Output: [3, 5, 9, 10, 12, 15, 18, 20, 21, 23, 25]
 */

/**
 * empty array -> return 0
 */
public class MergeTwoSortedArray {

    /**  APPROACH 1
     *  Insert and sort approach
     *  Time complexity - O((m + n)log(m + n))
     *  Space complexity - O(n) because of the in-built sort function takes extra space
     */
    public static void merge(int[] a, int[] b, int m, int n) {
        for (int i = 0; i < m + n; i++) {
            a[i + m] = b[i];
        }
        Arrays.sort(a);
    }

    /**
     * APPROACH 2
     * Merge Sort Method
     * In this method we'll be taking an extra temporary array to build our merged sorted array
     * Time Complexity - O(m + n)
     * Space Complexity - O(m + n) because we are taking an extra temporary array of size (m + n)
     */

    public static void mergeSort(int[] nums1, int[] nums2, int[] merged, int m, int n) {
        int i = m - 1;  // tracks nums1
        int j = n - 1;  // tracks nums2
        int k = m + n - 1; // tracks merged array

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                merged[k] = nums1[i];
                i--;
                k--;
            } else {
                merged[k] = nums2[j];
                j--;
                k--;
            }
        }
        while (i >= 0) {
            merged[k] = nums1[i];
            i--;
            k--;
        }
        while (j >= 0) {
            merged[k] = nums2[j];
            j--;
            k--;
        }
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 5};
        int[] nums2 = {2, 4, 6, 8};
        int m = 4;
        int n = 4;
        int[] merged = new int[m + n];


        //merge(nums1, nums2, m, n);
        mergeSort(nums1, nums2, merged, m, n);
        printArray(merged);
    }


}
