package Patterns.DynamicProgramming;

public class SubsetSum {


    public static boolean ifSubset(int[] arr, int sum, int n) {
        if (sum == 0) {
            return true;
        }
        if (n <= 0) {
            return false;
        }
        return ifSubset(arr, sum - arr[n - 1], n - 1) ||
               ifSubset(arr, sum, n - 1);

    }

    public static boolean ifSubsetDP(int[] arr, int sum, int n) {
        boolean[][] t = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    t[0][j] = false;
                }
                if (j == 0) {
                    t[i][0] = true;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }

            }
        }
        return t[n][sum];
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 7, 8, 10};
        int sum = 11;
        System.out.println(ifSubsetDP(arr, sum, arr.length));

    }
}
