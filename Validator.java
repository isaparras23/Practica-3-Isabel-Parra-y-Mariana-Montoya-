public class Validator {
    private String[][] boardMatrix = new String[8][8];
    private String error = "";

    public boolean validate(String pieces, String side, String castling, String enPassant, String half, String full) {

        String[] rows = pieces.split("/");
        if (rows.length != 8) {
            error = "Piece placement must have 8 rows.";
            return false;
        }

        for (int i = 0; i < 8; i++) {
            String row = rows[i];
            int colCount = 0;
            int col = 0;

            for (char c : row.toCharArray()) {
                if (Character.isDigit(c)) {
                    colCount += Character.getNumericValue(c);
                    col += Character.getNumericValue(c);
                } else if ("prnbqkPRNBQK".indexOf(c) != -1) {
                    if (col >= 8) {
                        error = "Too many squares in row ";
                        return false;
                    }
                    boardMatrix[i][col] = String.valueOf(c);
                    colCount++;
                    col++;
                } else {
                    error = "Invalid character '" + c + "' in row " + (i + 1);
                    return false;
                }
            }

            if (colCount != 8) {
                error = "Row " + (i + 1) + " must have exactly 8 squares.";
                return false;
            }
        }


        if (!side.matches("[wb]")) {
            error = "Invalid side to move: must be 'w' or 'b'.";
            return false;
        }


        if (!castling.matches("(-|[KQkq]+)")) {
            error = "Invalid castling field";
            return false;
        }


        if (!enPassant.matches("(-|[a-h][36])")) {
            error = "Invalid en passant target square";
            return false;
        }


        if (!half.matches("\\d+")) {
            error = "Halfmove must be a number.";
            return false;
        }
        int halfNum = Integer.parseInt(half);
        if (halfNum <0){
            error = "Invalid number, must be 0 or higher";
            return false;
        }

        if (!full.matches("\\d+")) {
            error = "Fullmove must be a number.";
            return false;
        }
        int fullNum = Integer.parseInt(full);
        if (fullNum < 1){
            error = "Invalid number,must be 1 or higher";
            return false;
        }

        return true;
    }

    public String[][] getBoardMatrix() {return boardMatrix;}

    public String getErrorMessage() {return error;}

}
