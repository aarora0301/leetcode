import java.util.PriorityQueue;

/*****
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */

public class KthSmallestElement {


    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<HeapNode> priorityQueue =
                new PriorityQueue<>((heapNode1, heapNode2) -> heapNode1.val - heapNode2.val);

        int N = Math.min(matrix.length, k);

        for (int i = 0; i < N; i++) {
            priorityQueue.offer(new HeapNode(matrix[i][0], i, 0));
        }

        HeapNode element = priorityQueue.peek();

        while (k > 0) {
            element = priorityQueue.poll();
            int row = element.row, col = element.col;
            if (col + 1 < N) {
                priorityQueue.add(new HeapNode(matrix[row][col + 1], row, col));
            }
            k--;

        }
        return element.val;
    }

    public static void main(String[] args) {

    }


}

class HeapNode {

    int val;
    int row;
    int col;

    public HeapNode(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }

}
