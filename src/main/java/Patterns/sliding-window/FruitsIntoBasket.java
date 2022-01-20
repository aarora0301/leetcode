import java.util.HashMap;
import java.util.Map;

/****
 * https://leetcode.com/problems/fruit-into-baskets/
 */
public class FruitsIntoBasket {

    public static int totalFruit(int[] fruits) {
        int count = 0, start = 0, k = 2, maxWin = Integer.MIN_VALUE, freq=0;
        Map<Integer, Integer> map = new HashMap<>();

        if (fruits == null || fruits.length == 0) {
            return 0;
        }
        for (int i = 0; i < fruits.length; i++) {
            if (!map.containsKey(fruits[i])) {
                count++;
            }
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while (count > k) {
                 freq = map.get(fruits[start]);
                freq--;

                if (freq == 0) {
                    count--;
                    map.remove(fruits[start]);
                } else {
                    map.put(fruits[start], freq);
                }
                start++;
            }
            maxWin = Math.max(maxWin, i - start + 1);
        }
        return maxWin;
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }

}
