public class Board {
    private Piece[][] board;

    public Board(String[][] matrix) {
        board = new Piece[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (matrix[i][j] != null) {
                    board[i][j] = new Piece(matrix[i][j].charAt(0));
                }
            }
        }
    }

    public void display() {
        System.out.println("  +-----------------+");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " | ");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[i][j].toUnicode() + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  +-----------------+");
        System.out.println("    a b c d e f g h");
    }
}
