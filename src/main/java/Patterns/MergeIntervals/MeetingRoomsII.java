import java.util.Arrays;

/***
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        int[] startInterval = new int[intervals.length];
        int[] endInterval = new int[intervals.length];
        int i = 0;
        for (int[] interval : intervals) {
            startInterval[i] = interval[0];
            endInterval[i] = interval[1];
            i++;
        }
        Arrays.sort(endInterval);
        Arrays.sort(startInterval);
        int usedRoom = 0, end = 0;

        for (i = 0; i < intervals.length; i++) {
            if (startInterval[i] >= endInterval[end]) {
                usedRoom--;
                end++;
            }
            usedRoom++;
        }
        return usedRoom;
    }

    public static void main(String[] args) {
        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
        int[][] intervals = new int[][]{{13, 15}, {1, 13}, {6, 9}};
        int ans = meetingRoomsII.minMeetingRooms(intervals);
        System.out.println(ans);
        intervals = new int[][]{{5, 8}, {6, 8}};
        ans = meetingRoomsII.minMeetingRooms(intervals);
        System.out.println(ans);
    }

}
