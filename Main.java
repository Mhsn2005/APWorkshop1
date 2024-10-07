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
        }

    }
}
