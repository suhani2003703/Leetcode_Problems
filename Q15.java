import java.util.*;

class Q15 {

    static class Element {
        int val, row, col;

        Element(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.val));

        
        for (int i = 0; i < n; i++) {
            pq.offer(new Element(matrix[i][0], i, 0));
        }

        
        for (int i = 0; i < k - 1; i++) {
            Element current = pq.poll();
            int row = current.row;
            int col = current.col;

        
            if (col + 1 < n) {
                pq.offer(new Element(matrix[row][col + 1], row, col + 1));
            }
        }

        
        return pq.poll().val;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        int k = 8;
        System.out.println("The " + k + "-th smallest element is: " + kthSmallest(matrix, k));
    }
}
