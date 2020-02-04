package main.java.Arrays;;

/**
 *
 A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring stops where distance[i] is the distance between the stops number i and (i + 1) % n.

 The bus goes along both directions i.e. clockwise and counterclockwise.

 Return the shortest distance between the given start and destination stops.

 Input: distance = [1,2,3,4], start = 0, destination = 1
 Output: 1
 Explanation: Distance between 0 and 1 is 1 or 9, minimum is 1.
 */
public class _1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (distance.length == 0 || distance == null || start == destination) {
            return -1;
        }
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int len = distance.length;
        /**
         * compute the pre-generated sum
         * so there are two possibilities of path
         * i. from start- destination which is preSum[destination]-preSum[start
         * ii. else all the numbers/paths excluding path from start-destination
         */
        int[] preSum = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            preSum[i] = preSum[i - 1] + distance[i - 1];
        }
        int diff = preSum[destination] - preSum[start];
        return Math.min(diff, preSum[len] - diff);
    }

    public static void main(String[] args) {
        _1184 test = new _1184();
        int[] distance = {7, 10, 1, 12, 11, 14, 5, 0};
        int start = 7;
        int dest = 2;
        System.out.println(test.distanceBetweenBusStops(distance, start, dest));
    }
}
