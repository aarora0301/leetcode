package main.java._30DayLeetcoding;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> hashSet = new HashSet<>();
        while (n != 1) {
            if (hashSet.contains(n)) {
                return false;
            }
            hashSet.add(n);
            n = computeSquare(n);
        }
        return true;
    }

    private int computeSquare(int num) {
        int result = 0;
        int digit;
        while (num > 0) {
            digit = num % 10;
            result += digit * digit;
            num = num / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        HappyNumber test = new HappyNumber();
        System.out.println(test.isHappy(91));
    }
}
