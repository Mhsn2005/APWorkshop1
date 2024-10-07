import java.util.Stack;

public class InfixToPostfix {
    private static int piority(char operation) { //first of all define the piority
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
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            char currentChar = infix.charAt(i);
            if (Character.isDigit(currentChar)) { // if the character is a number so we add it to stack
                stack.push(currentChar);
            }
            else if (currentChar == '(') { // and also if it is a '('
                stack.push(currentChar);
            }
            else if (currentChar == ')') { // but if it is a ')' so we have to process everything that is inside the parentheses
                while (!stack.isEmpty() && piority(stack.peek()) != '(') {
                    postfix.append(stack.pop()); // and by processing I mean add it to our postfix string
                }
                stack.pop(); // this one is to pop the '('
            }
            else { // but what if it's not a number , or parenthesis ; so it would be a operator
                while (!stack.isEmpty() && piority(stack.peek()) >= piority(currentChar)) {
                    postfix.append(stack.pop()); // if the priority of the operator in our stack is grater than the new one , so we have to add the one in the stack to our postfix string and then append the current one
                }
                stack.push(currentChar);// just like I mentioned we append it to stack "after" the while loop
            }
            while (!stack.isEmpty() ) {
                postfix.append(stack.pop()); // and at the end we pop everything to our postfix
            }
        }
        return postfix.toString();
    }
}

