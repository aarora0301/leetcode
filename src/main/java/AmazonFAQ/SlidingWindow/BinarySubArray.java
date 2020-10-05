package main.java.AmazonFAQ.SlidingWindow;

public class BinarySubArray {

    public int numSubarraysWithSum(int[] A, int S) {
        int j = 0;
        int sum = 0;
        int count = 0;
        if (A == null || A.length == 0) {
            return 0;
        }
        for (int i = 0; i < A.length; i++) {
            j = i+1;
            sum = A[i];
            if (sum==S){
                count++;
            }
            while (sum <= S && j < A.length) {
                sum += A[j];
                j++;
                if (sum == S) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = new int[]{0,0,0,0,0};
        BinarySubArray bs = new BinarySubArray();
        System.out.println(bs.numSubarraysWithSum(A, 0));
    }
}
