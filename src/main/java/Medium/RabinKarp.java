package main.java.Medium;

import java.math.BigInteger;
import java.util.Random;

public class RabinKarp {

    private String pattern;
    private long patternHash;
    private int patLength;
    private long q;
    private int R;
    private long RM;

    public RabinKarp(String pattern) {
        this.pattern = pattern;
        /***
         *  R = 256 because assuming we have 256 ASCII characters
         */
        this.R = 256;
        this.RM = 1;
        this.patLength = pattern.length();
        this.q = randomPrime();
        /***
         *  Get largest multiplier, as we are calculating hash as below:
         *   example: "cab"
         *   256^2 (ascii value of c) + 256^1 (ascii value of a) + 256^0 (ascii value of b)
         *   below iteration will get RM = 256 ^2
         */
        for (int i = 0; i < patLength - 1; i++) {
            RM = (R * RM) % q;
        }
        patternHash = hash(pattern, patLength);

    }

    private long randomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    /***
     *  Hash of : "cab" = 256^2 (ascii value of c) + 256^1 (ascii value of a) + 256^0 (ascii value of b)
     * @param pattern
     * @param patLength
     * @return
     */
    private long hash(String pattern, int patLength) {
        long hash = 0;
        for (int i = 0; i < patLength; i++) {
            hash = (R * hash + pattern.charAt(i)) % q;
        }
        return hash;
    }

    private boolean check(String text, int offSet) {
        for (int j = 0; j < patLength; j++) {
            if (pattern.charAt(j) != text.charAt(offSet + j)) {
                return false;
            }
        }
        return true;
    }

    private int search(String text) {
        int textLen = text.length();
        if (textLen < patLength) {
            return textLen;
        }
        long textHash = hash(text, patLength);
        if (patternHash == textHash && check(text, 0)) {
            return 0;
        }
        for (int i = patLength; i < textLen; i++) {
            /***
             * Run Rolling hash algorithm aka sliding window
             */
            // Remove leading digit,
            textHash = (textHash + q - RM * text.charAt(i - patLength) % q) % q;
            //add trailing digit
            textHash = (textHash * R + text.charAt(i)) % q;
            int offSet = i - patLength + 1;
            //check for match.
            if (textHash == patternHash && check(text, offSet)) {
                return offSet;
            }
        }
        return textLen;
    }

    public static void main(String[] args) {
        RabinKarp test = new RabinKarp("aab");
        String text = "caab";
        System.out.println(test.search(text));
        System.out.println(text.length());
    }

}
