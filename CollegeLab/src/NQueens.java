public class NQueens {

    static int[] x; // x[k] = column where queen is placed in row k
    static int n;

    // Function to check if queen can be placed at row k, column i
    public static boolean place(int k, int i) {
        for (int j = 1; j < k; j++) {
            // Same column OR same diagonal
            if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k)) {
                return false;
            }
        }
        return true;
    }

    // Backtracking function to place queens
    public static void nQueens(int k) {
        for (int i = 1; i <= n; i++) {
            if (place(k, i)) {
                x[k] = i;

                if (k == n) {
                    printSolution();
                } else {
                    nQueens(k + 1);
                }
            }
        }
    }

    // Print solution
    public static void printSolution() {
        for (int i = 1; i <= n; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        n = 4; // Change this value for different N
        x = new int[n + 1]; // 1-based indexing

        nQueens(1);
    }
}