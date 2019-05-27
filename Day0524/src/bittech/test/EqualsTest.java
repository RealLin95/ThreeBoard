package bittech.test;

import java.util.Scanner;
import java.util.Stack;

//括号匹配
public class EqualsTest {
    public static boolean equalst(String str){
        if(str==null){
            return false;
        }
        if(str.equals("")){
            return true;
        }
        int n = str.length();
        Stack<Character> stack1 = new Stack<>();
        for(int i = 0;i<n;i++){
            if(str.charAt(i)=='('||str.charAt(i)=='['||str.charAt(i)=='{'){
                stack1.push(str.charAt(i));
            }else if(str.charAt(i)==')'||str.charAt(i)=='}'||str.charAt(i)==']'){
                if(judge(stack1.peek(),str.charAt(i))){
                    stack1.pop();
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        if(stack1.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public  static boolean judge(char l,char r){
        if((l=='(')&&(r==')')){
            return true;
        }else if((l=='[')&&(r==']')){
            return true;
        }else if((l=='{')&&(r=='}')){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            System.out.println(equalst(str));
        }
    }
}
