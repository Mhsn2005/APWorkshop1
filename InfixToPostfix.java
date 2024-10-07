import java.util.Stack;

public class InfixToPostfix {
    private static int piority(char operation) {
        switch (operation) {
            case '+':
                case '-':
                    return 1;
            case '*':
            case '/':
                     return 2;
            default:
                     return 0;
        }
    }

}

