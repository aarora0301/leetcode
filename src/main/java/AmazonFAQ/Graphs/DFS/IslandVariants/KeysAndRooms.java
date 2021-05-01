package main.java.AmazonFAQ.Graphs.DFS.IslandVariants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*****
 * [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 *
 * Initially, all the rooms start locked (except for room 0).
 *
 * You can walk back and forth between rooms freely.
 *
 * Return true if and only if you can enter every room.
 *
 * Example 1:
 *
 * Input: [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We start in room 0, and pick up key 1.
 * We then go to room 1, and pick up key 2.
 * We then go to room 2, and pick up key 3.
 * We then go to room 3.  Since we were able to go to every room, we return true.
 */
public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) {
            return false;
        }
        int totalRooms = rooms.size();
        boolean[] isVisited = new boolean[totalRooms];

        dfs(isVisited, 0, rooms);

        isVisited[0] = true;
        for (boolean flag : isVisited) {
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    public void dfs(boolean[] isVisited, int roomIndex, List<List<Integer>> room) {

        for (int neighbours : room.get(roomIndex)) {

            if (roomIndex == neighbours) {
                continue;
            }
            if (!isVisited[neighbours]) {
                isVisited[neighbours] = true;
                dfs(isVisited, neighbours, room);
            }
        }
    }

    public static void main(String[] args) {
        int[][] rooms = new int[][] {{4},{3},{},{2,5,7},{1},{},{8,9},{},{},{6}};
        KeysAndRooms kr = new KeysAndRooms();
        List<List<Integer>> list = Arrays.stream(rooms)
                .map(row -> IntStream.of(row).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());
        System.out.println(kr.canVisitAllRooms(list));
    }
}
