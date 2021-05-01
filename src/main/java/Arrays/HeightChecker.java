package Arrays;

import java.util.Arrays;

/***
 * 1051
 * Students are asked to stand in non-decreasing order of heights for an annual photo.
 *
 * Return the minimum number of students not standing in the right positions.  (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)
 *
 * Input: [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * Students with heights 4, 3 and the last 1 are not standing in the right positions.
 */
public class HeightChecker {

    public int heightChecker(int[] heights) {
        if (heights == null || heights.length <= 1) {
            return 0;
        }
        int len = heights.length;
        int[] arr = Arrays.copyOf(heights, len);
        int count = 0;
        for (int i = 1; i < len; i++) {
            int index = i - 1;
            int temp = arr[i];

            /**
             * using the insertion sort idea
             *  since the array is almost sorted
             */
            if (arr[index] <= arr[i]) {
                continue;
            }
            while (index >= 0 && arr[index] > temp) {
                arr[index + 1] = arr[index];
                index--;

            }
            arr[index + 1] = temp;
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        HeightChecker hc = new HeightChecker();
        int[] heights = {1, 1, 4, 2, 1, 3};
        System.out.println(hc.heightChecker(heights));
    }
}
