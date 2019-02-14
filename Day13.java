import javax.crypto.IllegalBlockSizeException;

/* 1. good
    good */

/*  2.利用接口做参数，写个计算器，能完成加减乘除运算。 
（1）定义一个接口Compute含有一个方法int computer(int n, int m)。 
（2）设计四个类分别实现此接口，完成加减乘除运算。 
（3）设计一个类UseCompute，类中含有方法：public void useCom(Compute com, int one, int two)，此方法能够用传递过来的对象调用computer方法完成运算，并输出运算的结果。 
（4）设计一个主类Test，调用UseCompute中的方法useCom来完成加减乘除运算。  
interface Compute{
    int computer(int n,int m);
}
class Add implements Compute{
    public int computer(int n,int m){
        return n+m;
    }
}
class Sub implements Compute{
    public int computer(int n,int m){
        return n-m;
    }
}
class Mul implements Compute{
    public int computer(int n,int m){
        return n*m;
    }
}
class Div implements Compute{
    public int computer(int n,int m){
        return n/m;
    }
}
class UseCompute {
    public void useCom(Compute com,int one,int two){
        System.out.println(com.computer(one, two));
    }
}
public class Day13{
    public static void main(String[] args){
        UseCompute use = new UseCompute();
        use.useCom(new Add(), 4, 2);
        use.useCom(new Sub(), 4, 2);
        use.useCom(new Mul(), 4, 2);
        use.useCom(new Div(), 4, 2);
    }
}
*/

/*（1）定义接口A，里面包含值为3.14的常量PI和抽象方法double area()。 
（2）定义接口B，里面包含抽象方法void setColor(String c)。 
（3）定义接口C，该接口继承了接口A和B，里面包含抽象方法void volume()。 
（4）定义圆柱体类Cylinder实现接口C，该类中包含三个成员变量：底圆半径radius、 
圆柱体的高height、颜色color。 
（5）创建主类来测试类Cylinder。 

interface A{
    double PI = 3.14;
    double area();
}
interface B{
    void setColor(String c);
}
interface C extends A,B{
    void volume();
}
class Cylinder implements C{
    private int radius = 1;
    private int height = 2;
    public String color;
    public double area(){
        return PI*radius*radius;
    }
    public void setColor(String c){
        this.color = c;
    }
    public void volume(){
        System.out.println(height*area());
    }
}
public class Day13{
    public static void main(String[] args){
        C c = new Cylinder();
        c.volume();
        System.out.println(c.area());
        c.setColor("yellow");
    }
}
*/

