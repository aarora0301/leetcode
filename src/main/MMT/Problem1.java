package main.MMT;


import java.util.ArrayList;
import java.util.List;

public class Problem1 {


    private List<Integer> getNumbers(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        int len = arr.length;
        List<Integer> result = new ArrayList<>();
        int rightMax = arr[len - 1];
        result.add(rightMax);
        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] > rightMax) {
                result.add(arr[i]);
                rightMax = arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        int[] arr = {9, 3, 5, 6, 7, 1};
        List<Integer> result = problem1.getNumbers(arr);
        System.out.println(result);
    }
}
