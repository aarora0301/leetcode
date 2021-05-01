package main.java.Easy;

import java.util.ArrayList;
import java.util.List;

public class ShiftZero {

    public List<Integer> processArray(final List<Integer> input) {
        if (input == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int countZero = 0;
        for (int num : input) {
            if (num != 0) {
                result.add(num);
            } else {
                countZero++;
            }
        }
        for (int i = 0; i < countZero; i++) {
            result.add(0);
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
