// рограмма рекурсивно решает задачу обхода шахматной доски 5x5 конём. 
// При запуске программа выводит последовательность чисел от 1 до 25, представляющих порядок посещения клеток конём. 
// Каждое число соответствует клетке, в которой конь находился на определенном шаге.

public class KnightTour {
    private static final int SIZE = 5;
    private static final int[][] moves = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    private static int[][] board = new int[SIZE][SIZE];
    private static int moveCount = 1;

    public static void main(String[] args) {
        solveKnightTour(0, 0);
        printBoard();
    }

    private static void solveKnightTour(int row, int col) {
        board[row][col] = moveCount++;
        
        if (moveCount > SIZE * SIZE) {
            return;
        }

        for (int[] move : moves) {
            int newRow = row + move[0];
            int newCol = col + move[1];

            if (isValidMove(newRow, newCol)) {
                solveKnightTour(newRow, newCol);
            }
        }

        if (moveCount <= SIZE * SIZE) {
            board[row][col] = 0;
            moveCount--;
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == 0;
    }

    private static void printBoard() {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.printf("%2d ", cell);
            }
            System.out.println();
        }
    }
}