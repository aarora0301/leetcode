package Assessment1;

import java.util.Set;

public class RotatedDigit {

    public int rotatedDigits(int n) {

        if (n == 0) {
            return 0;
        }

        int count = 0;
        Set<Integer> set = Set.of(2, 5, 6, 9);
        Set<Integer> set2 = Set.of(3, 4, 7);
        for (int i = 1; i <= n; i++) {
            boolean flag2569 = false;
            boolean flag347 = false;
            int mod = i;
            while (mod > 0) {
                int temp = mod % 10;
                mod = mod / 10;
                if (set.contains(temp)) {
                    flag2569= true;
                }else if (set2.contains(temp)){
                    flag347= true;
                }
            }
            if (!flag347 && flag2569) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RotatedDigit rotatedDigit = new RotatedDigit();
        System.out.println(rotatedDigit.rotatedDigits(10));
    }

}
