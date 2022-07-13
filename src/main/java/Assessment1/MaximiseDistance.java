package Assessment1;

import java.util.Arrays;

public class MaximiseDistance {

    public static void main(String[] args) {
        MaximiseDistance maximiseDistance = new MaximiseDistance();
        System.out.println(maximiseDistance.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        System.out.println(maximiseDistance.maxDistToClosest(new int[]{1, 0, 0, 0}));
        System.out.println(maximiseDistance.maxDistToClosest(new int[]{0,1}));

    }

    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, Integer.MAX_VALUE);
        Arrays.fill(right, Integer.MAX_VALUE);
        int answer = 0;
        int index = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                left[i] = 0;
                index = i;

            } else if (i > 0 && index<i &&seats[i] == 0) {
                left[i] = i-index;
            }
        }

        index = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                right[i] = 0;
                index = i;

            } else if (i < n - 1 && index <=n-1&& seats[i] == 0) {
                right[i] = index-i;
            }
        }

       System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer,Math.min(left[i], right[i]));
        }

        return answer;
    }

}
