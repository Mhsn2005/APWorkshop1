import java.util.Stack;

public class ProcessPostfix {
    public static int processPostfix(String expression) { // Are you ready to process the postfix ?     There we go
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char currentcahr = expression.charAt(i);
            if (Character.isDigit(currentcahr)) { // obviously if it is a number we add it to our stack
                stack.push(Integer.parseInt(currentcahr + ""));
            }
            else { // here's the interesting part : if it is something beside number so it is a operation so we have to pop the two last numbers to process it with the operation
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (currentcahr) {
                    case '+':
                        stack.push(num1 + num2);
                        break;
                    case '-':
                        stack.push(num1 - num2);
                        break;
                    case '*':
                        stack.push(num1 * num2);
                        break;
                    case '/' :
                        stack.push(num1 / num2);
                        break;
                }
            }
        }
        return stack.pop(); // easily done !
    }
}
