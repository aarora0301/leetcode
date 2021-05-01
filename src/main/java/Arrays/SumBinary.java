package main.java.Arrays;

public class SumBinary {


    private int sum(int[] arr, int left, int right) {
        int sum = 0;
        int start = 0;
        int end = arr.length - 1;
        if (arr[end] == 0) {
            return 0;
        }
        if (arr[start] == 1) {
            return end - start + 1;
        }
        int mid = start + (end - start / 2);
        return sum(arr, left, mid) + sum(arr, mid + 1, right);
    }

    public static void main(String[] args) {

    }
}
