public class Parser {
    private String error = "";
    private String[][] boardMatrix;
    public boolean verifyFields (String fen){
        String[] fields = fen.trim().split(" ");
        if(fields.length != 6){
            error = "FEN must have 6 fields";
            return false;
        }
        String piecePlacement = fields[0];
        String sideToMove = fields[1];
        String castlingAbility = fields[2];
        String enPassantTargetSquare = fields[3];
        String halfmoveClock = fields[4];
        String fullmoveCounter = fields[5];

        Validator validator = new Validator();
        boolean valid = validator.validate(piecePlacement, sideToMove, castlingAbility, enPassantTargetSquare, halfmoveClock, fullmoveCounter);

        if (valid) {
            this.boardMatrix = validator.getBoardMatrix();
            return true;
        } else {
            this.error = validator.getErrorMessage();
            return false;
        }
    }

    public String[][] getBoardMatrix() {
        return boardMatrix;
    }

    public String getErrorMessage() {
        return error;
    }
}
