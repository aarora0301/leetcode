package main.java._30DayLeetcoding;

/****
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 *
 * direction can be 0 (for left shift) or 1 (for right shift).
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation:
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 */
public class PerformingStringShifts {

    public String stringShift(String s, int[][] shift) {
        int countLeft = 0, countRight = 0, diff = 0;
        for (int[] arr : shift) {
            countRight += arr[0] == 1 ? arr[1] : 0;
            countLeft += arr[0] == 0 ? arr[1] : 0;
        }
        diff = Math.abs(countLeft - countRight);
        while (diff >= s.length()) {
            diff -= s.length();
        }
        return rotate(countRight > countLeft, diff, s);
    }


    private String rotate(boolean flag, int rotationStep, String originalString) {
        String result = "";
        int len = originalString.length();
        /**
         * flag =true , rotate right
         */
        if (flag) {
            result = originalString.substring(len - rotationStep) + originalString.substring(0, len - rotationStep);
        } else
            result = originalString.substring(rotationStep) + originalString.substring(0, rotationStep);
        return result;
    }

    public static void main(String[] args) {
        PerformingStringShifts test = new PerformingStringShifts();
        System.out.println(test.stringShift("xqgwkiqpif", new int[][]{{1, 4}, {0, 7}, {0, 8}, {0, 7}, {0, 6}, {1, 3}, {0, 1}, {1, 7}, {0, 5}, {0, 6}}));
    }
}
