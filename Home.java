import java.util.Scanner;
public class Home{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);  //等待输入
        System.out.println("请输入姓名");
        String name = input.nextLine();  //字符串的输入方式
        System.out.println("请输入年龄");
        int age = input.nextInt();   //整型的输入方式
        System.out.println("请输入身高");
        double height = input.nextDouble();   //浮点型的输入方式
        System.out.println("本人"+name+"年龄"+age+"身高"+height);
    }
}