import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    InfixToPostfix ItoP = new InfixToPostfix();
    ProcessPostfix PP = new ProcessPostfix();
    int Result = ProcessPostfix.processPostfix(InfixToPostfix.infixToPostfix(input.nextLine()));
        System.out.println();
    }
}
