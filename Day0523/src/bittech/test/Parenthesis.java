package bittech.test;

import java.util.Scanner;
import java.util.Stack;

//合法括号判断
public class Parenthesis {

    public boolean chkParenthesis(String A, int n) {
        StringBuilder str = new StringBuilder(A);
        Stack<Character>  stack = new Stack<>();
        if(A==null||n==0||A==""){
            return false;
        }
        for(int i= 0;i<n;i++){
            char temp = str.charAt(i);
            if(temp == '('){
                stack.push(temp);
            }else if(temp == ')'){
                if(stack.isEmpty()){
                    return false;
                }else if(stack.peek().equals('(')){
                    stack.pop();
                    continue;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        if(stack.size()==0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parenthesis parenthesis = new Parenthesis();
        while(scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(parenthesis.chkParenthesis(str, str.length()));
        }
    }
}
