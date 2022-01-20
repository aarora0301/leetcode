package DS_14Days;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        boolean temp = false;
        for (int num : nums) {
            temp = set.add(num);
            if (!temp) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean result = containsDuplicate(new int[]{1, 2, 3, 1});
        System.out.println(result);
    }
}
