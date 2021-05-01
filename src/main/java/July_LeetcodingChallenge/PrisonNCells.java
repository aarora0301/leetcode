package main.java.July_LeetcodingChallenge;

import java.util.*;


/***
 *
 * There are 8 prison cells in a row, and each cell is either occupied or vacant.
 *
 * Each day, whether the cell is occupied or vacant changes according to the following rules:
 *
 * If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
 * Otherwise, it becomes vacant.
 * (Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
 *
 * We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.
 *
 * Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)
 *
 *
 * Example 1:
 *
 * Input: cells = [0,1,0,1,1,0,0,1], N = 7
 * Output: [0,0,1,1,0,0,0,0]
 * Explanation:
 * The following table summarizes the state of the prison on each day:
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 * Sol: https://www.youtube.com/watch?v=KcEtcBDX76w
 */
public class PrisonNCells {


    public int[] prisonAfterNDays(int[] cells, int N) {
        /**
         * Find block size, i.e after how many iterations pattern will repeat
         */
        int size = 0;
        boolean flag = false;
        Set<String> hashSet = new HashSet<>();
        Map<Integer, int[]> map = new HashMap<>();
        map.put(0, cells);
        for (int i = 0; i < N; i++) {
            int[] nextDay = getNextDay(cells);
            String next = Arrays.toString(nextDay);
            if (!hashSet.contains(next)) {
                hashSet.add(next);
                size++;
                map.put(size, Arrays.copyOf(nextDay, nextDay.length));
            } else {
                flag = true;
                break;
            }

            /**
             * update cells with each day
             */
            cells = nextDay;
        }

        if (flag) {
            N = (N - 1) % size;
            cells = map.get(N);
//            for (int i=1; i<=N; i++){
//                cells= getNextDay(cells);
//            }
        }
        return cells;
    }

    private int[] getNextDay(int[] cells) {
        if (cells == null) {
            return cells;
        }
        int[] result = new int[cells.length];
        /**
         *  first and last cell will always be zero
         */
        for (int i = 1; i < cells.length - 1; i++) {
            if (cells[i - 1] == cells[i + 1]) {
                result[i] = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PrisonNCells test = new PrisonNCells();
        System.out.println(Arrays.toString(test.prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000)));
    }
}
