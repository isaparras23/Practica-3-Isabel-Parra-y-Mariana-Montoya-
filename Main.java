import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a FEN string:");
        String fen = scanner.nextLine();
        Parser parser = new Parser();
        if (parser.verifyFields(fen)) {
            System.out.println("FEN string is valid");
            Board board = new Board(parser.getBoardMatrix());
            board.display();
        } else {
            System.out.println("Invalid FEN string: " + parser.getErrorMessage());
        }
    }
}
