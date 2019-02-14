//import java.util.Scanner;
/* 简单工厂模式
interface Computer{
    void printComputer();
}
class Macbook implements Computer{
    public void printComputer(){
        System.out.println("This is Macbook");
   }
}
class Surface implements Computer{
    public void printComputer(){
        System.out.println("This is Surface");
    }
}
class ComputerFactory{
    public static Computer getInfo(String name){  //返回Computer类对象
        Computer com = null;
        if(name.equals("Macbook")){
            return new Macbook();
        }else if(name.equals("Surface")){
            return new Surface();
        }return com;
    }
}
public class Method{
    public void buyComputer(Computer com){
        com.printComputer();
    }
    public static void main(String[] args){
        Method m = new Method();   //创建一个类对象
        Scanner input = new Scanner(System.in);  //输入想要的电脑名称
        System.out.println("请输入您要购买的电脑名称...");
        String name = input.nextLine();         //将名称赋给name
        Computer com = ComputerFactory.getInfo(name); //比对想要哪个电脑，并new出此电脑的实例化对象
        m.buyComputer(com);  //将实例化对象传给方法，调用相应的类对象方法买相应的电脑
    }
}
*/

/*工厂方法模式
interface Computer{
    public abstract void printComputer();
}
class Macbook implements Computer{
    public void printComputer(){
        System.out.println("This is Macbook");
    }
}
class Surface implements Computer{
    public void printComputer(){
        System.out.println("This is Surface");
    }
}
interface ComputerFactory{
    public abstract Computer createComputer();
}
class AppleFactory implements ComputerFactory{
    public Computer createComputer(){
        return new Macbook();
    }
}
class MsFactory implements ComputerFactory{
    public Computer createComputer(){
        return new Surface();
    }
}
public class Method{
    public void buyComputer(Computer com){
        com.printComputer();
    }
    public static void main(String[] args){
        Method m = new Method();
        ComputerFactory c = new AppleFactory();  //客户端决定实例化哪个对象
        Computer com = c.createComputer();       //调用工厂方法产生产品的实例化对象
        m.buyComputer(com);    //根据相应的工厂类生产相应的产品类，并调用产品类方法
    }
}
*/

/*抽象工厂模式
interface Computer{
    void printComputer();
}
class Macbook implements Computer{
    public void printComputer(){
        System.out.println("This is Macbook");
    }
}
class Surface implements Computer{
    public void printComputer(){
        System.out.println("This is Surface");
    }
}
interface Systom{
    void printSystom();
}
class IOS implements Systom{
    public void printSystom(){
        System.out.println("This is IOS system");
    }
}
class Windows implements Systom{
    public void printSystom(){
        System.out.println("This is Windows system");
    }
}
interface GoodFactory{
    Computer createComputer();
    Systom createSystom();
}
class AppleFactory implements GoodFactory{
    public Computer createComputer(){
        return new Macbook();
    }
    public Systom createSystom(){
        return new IOS();
    }
}
class MsFactory implements GoodFactory{
    public Computer createComputer(){
        return new Surface();
    }
    public Systom createSystom(){
        return new Windows();
    }
}
public class Method{
    public void buyComputer(Computer com){
        com.printComputer();
    }
    public void buySystom(Systom sys){
        sys.printSystom();
    }
    public static void main(String[] args){
        Method m = new Method();
        GoodFactory fac = new AppleFactory();   //创建工厂类
        Computer com = fac.createComputer();    //调用该工厂方法，实例化子类产品对象--电脑
        Systom sys = fac.createSystom();        //调用该工厂方法，实例化子类产品对象--系统
        m.buyComputer(com);               //通过产生的对象调用相应的买电脑方法
        m.buySystom(sys);                 //通过产生的对象调用相应的买系统方法
    }
}
*/