public class Piece {
    private char symbol;
    private boolean white;

    public Piece(char symbol) {
        this.symbol = symbol;
        this.white = Character.isUpperCase(symbol);
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean white() {
        return white;
    }

    public String toUnicode() {
        char s = Character.toLowerCase(symbol);
        switch (s) {
            case 'p':
                if (white) {
                    return "♙";
                } else {
                    return "♟";
                }

            case 'r':
                if (white) {
                    return "♖";
                } else {
                    return "♜";
                }

            case 'n':
                if (white) {
                    return "♘";
                } else {
                    return "♞";
                }

            case 'b':
                if (white) {
                    return "♗";
                } else {
                    return "♝";
                }

            case 'q':
                if (white) {
                    return "♕";
                } else {
                    return "♛";
                }

            case 'k':
                if (white) {
                    return "♔";
                } else {
                    return "♚";
                }
            default:
                return "?";
        }
    }
}
