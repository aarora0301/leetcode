package main.java.May_LeetCodingChallenge.Week1;

/****
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int majorityElement = -1;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                majorityElement = num;
            }
            count += majorityElement == num ? 1 : -1;
        }
        return majorityElement;
    }

    public static void main(String[] args) {
        MajorityElement test = new MajorityElement();
        System.out.println(test.majorityElement(new int[]{3, 2, 3}));


    }
}
