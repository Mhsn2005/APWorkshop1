import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
         Stack<Integer> stack = new Stack<>();
        int num=0;
        int sign=1;
        char operator='+';
        Operations op = new Operations();
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        for (int i = 0; i < s.length(); i++) {//starting to proccessing the input
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0'; // for managing numbers grater than 9
            }
            else if (ch=='+' || ch=='-' || ch=='*' || ch=='/') {
                 op.operate(operator , num , sign , stack); // first we operate the last operation
                 operator=ch; //now updating the operator and the number to the new ones
                 num=0;
                 if(ch=='+'){ // we should update the sign too
                     sign=1;
                 }
                 else if (ch=='-'){
                     sign=-1;
                 }
            }
            else if (ch=='(') {
                stack.push(sign); // to know what was the sign before the parentheses
                stack.push(null); // to know where our parentheses opened
                // reset the number and other things for going inside the parentheses
                sign=1;
                operator='+';
                num=0;
            }
            else if (ch==')') {
                op.operate(operator , num , sign , stack); // processing the last function that was in the parentheses
                num=0; // we want to get outside the parentheses so we should reset the number
                int innersum=0; // for the result inside the parentheses
                while (stack.peek() != null) { // we go ahead and process the innersum until we reach the null ( start of the parentheses)
                    innersum += stack.pop();
                }
                stack.pop(); // for pop the null in stack
            }
        }

    }
}
