public class MindTickle {


    /****
     *    5,3,4,5
     * @param args
     */
    public static void main(String[] args) {
        MindTickle mindTickle = new MindTickle();
        System.out.println(mindTickle.getMaxArea(new int[]{5, 3, 4, 4, 5}));

    }

    public int getMaxArea(int[] bars) {
        if (bars == null || bars.length == 0) {
            return 0;
        }
        int[] left = new int[bars.length];
        int[] right = new int[bars.length];

        left[0] = bars[0];
        right[bars.length - 1] = bars[bars.length - 1];

        for (int i = 1; i < bars.length; i++) {
            left[i] = Math.max(left[i - 1], bars[i]);
        }

        for (int i = bars.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], bars[i]);
        }

        int result = 0;
        for (int i = 0; i < bars.length; i++) {
            result += Math.min(left[i], right[i]) - bars[i];
        }
        return result;
    }
}
