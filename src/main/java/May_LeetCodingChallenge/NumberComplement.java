package main.java.May_LeetCodingChallenge;

/****
 * Given a positive integer num, output its complement number. The complement strategy
 * is to flip the bits of its binary representation.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its
 * complement is 010. So you need to o
 */
public class NumberComplement {
    public int findComplement(int num) {
        int bitLength = (int) (Math.log(num) / Math.log(2)) + 1;
        int bitMask = (1 << bitLength) - 1;
        return num ^ bitMask;
    }

    public static void main(String[] args) {
        NumberComplement test = new NumberComplement();
        System.out.println(test.findComplement(5));
    }
}
