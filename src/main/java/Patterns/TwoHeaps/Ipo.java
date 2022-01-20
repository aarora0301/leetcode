import java.util.PriorityQueue;

/*****
 * https://leetcode.com/problems/ipo/
 */
class Capital {

    public int amount;
    public Integer index;

    protected Capital(int amount, int index) {
        this.amount = amount;
        this.index = index;
    }
}

public class Ipo {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        /**
         * Min heap
         */
        PriorityQueue<Capital> capitalQueue = new PriorityQueue<>((a, b) -> a.amount - b.amount);
        /**
         * Max Heap
         */
        PriorityQueue<Integer> profitQueue = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < capital.length; i++) {
            capitalQueue.add(new Capital(capital[i], i));
        }

        int currAmount = w;
        for (int i = 0; i < k; i++) {
            while (!capitalQueue.isEmpty() && currAmount >= capitalQueue.peek().amount) {
                Capital leastCap = capitalQueue.poll();
                profitQueue.add(profits[leastCap.index]);
            }
            currAmount += !profitQueue.isEmpty() ? profitQueue.poll() : 0;
        }
        return currAmount;
    }

    public static void main(String[] args) {

    }
}
