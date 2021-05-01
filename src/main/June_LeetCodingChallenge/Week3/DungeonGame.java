package main.June_LeetCodingChallenge.Week3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N
 * rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the
 * dungeon to rescue the princess.
 *
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he
 * dies immediately.
 *
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are
 * either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 *
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 *
 *
 *
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 *
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal
 * path RIGHT-> RIGHT -> DOWN -> DOWN.
 *
 * Note:
 *
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess
 * is imprisoned.
 */
public class DungeonGame {

    int minSum = Integer.MAX_VALUE;
    List<Integer> res;

    /***
     *  This function gets the path which will take min strength
     *  but processing need to be fixed
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int currentSum = 0;
        List<Integer> route = new ArrayList<>();
        backTrack(0, 0, dungeon, currentSum, route);
        /***
         *   below method is not working as expected: to be fixed
         */
        return processList(res);

    }

    public void backTrack(int x, int y, int[][] dungeon, int currentSum, List<Integer> route) {
        if (x < 0 || x > dungeon.length - 1 || y < 0 || y > dungeon[0].length - 1) {
            return;
        }

        route.add(dungeon[x][y]);
        backTrack(x + 1, y, dungeon, currentSum + dungeon[x][y], route);
        backTrack(x, y + 1, dungeon, currentSum + dungeon[x][y], route);

        if (x == dungeon.length - 1 && y == dungeon[0].length - 1) {
            currentSum += dungeon[x][y];
            if (Math.abs(currentSum) < minSum) {
                minSum = Math.abs(currentSum);
                res = new ArrayList<>();
                res.addAll(route);
            }
        }
        route.remove(route.size() - 1);
    }

    private int processList(List<Integer> list) {
        int negSum = 0, postSum = 0;
        for (int num : list) {
            if (num < 0) {
                negSum += num;
            } else postSum += num;
        }
        int cancelNeg = Math.abs(negSum) + 1;
        if (cancelNeg == 1) {
            return cancelNeg;
        } else if (cancelNeg > postSum && (cancelNeg - postSum) < cancelNeg -1 ) {
            return cancelNeg - postSum;
        }
        else if (postSum > cancelNeg) {
            return postSum - cancelNeg;
        } else {
            return cancelNeg;
        }
    }

    public static void main(String[] args) {
        DungeonGame test = new DungeonGame();
        System.out.println(test.calculateMinimumHP(new int[][]{{2,1 },{1,-1}}));
        System.out.println(test.res);
    }
}
