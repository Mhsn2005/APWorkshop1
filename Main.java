import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    InfixToPostfix ItoP = new InfixToPostfix();
    ProcessPostfix PP = new ProcessPostfix();
    String expression = input.nextLine();
    String postFix = ItoP.infixToPostfix(expression);
    int result = PP.processPostfix(postFix);
        System.out.println(result);
    }
}
