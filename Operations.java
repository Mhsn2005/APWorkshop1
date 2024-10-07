import java.util.Stack;

public class   Operations{
    private char OP ;
    private int num;
    protected void operate(char op , int num , int sign , Stack<Integer> stack) {
        this.OP = op;
        this.num = num;
        switch (OP){
            case'+':
                stack.push(sign * num);
            break;
            case '-':
                stack.push(sign * -num);
                break;
            case '*':
                stack.push(stack.pop()*num);
                break;
            case '/':
                stack.push(stack.pop()/num);
                break;}
    }


}
