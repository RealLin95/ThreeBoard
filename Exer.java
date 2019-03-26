package bittech3;

class Color{
    private String title;
    public static final int RED_NUMBER = 1;
    public static final int YELLOW_NUMBER = 2;
    public static final int BLUE_NUMBER = 3;
    private static final Color Red = new Color("Red");
    private static final Color Yellow = new Color("Yellow");
    private static final Color Blue = new Color("Blue");
    private Color(String title){//构造方法私有化
        this.title = title;
    }
    public static Color getInsatance(int ch){//通过staic方法取得实例化对象
        switch(ch){
            case RED_NUMBER:
                return Red;
            case YELLOW_NUMBER:
                return Yellow;
            case BLUE_NUMBER:
                return Blue;
            default:
                return null;
        }
    }
    public String toString(){
        return this.title;
    }
}

interface IColor{
    void print();
}
enum Colors implements IColor{//枚举可以实现接口，枚举中的每个对象都变成了接口对象
    RED("红"),YELLOW("黄"),BLUE("蓝");//枚举对象必须写在第一行
    private String title;
    private Colors(String title){
        this.title = title;
    }
    public String toString(){//枚举支持构造方法，普通方法
        return this.title;
    }
    public void print(){
        System.out.println(this.title);
    }
}

enum Sex{
    MALE("男"),FEMALE("女");
    private String title;
    private Sex(String title){
        this.title = title;
    }
    public String toString(){
        return this.title;
    }
}

class Person{
    private String name;
    private int age;
    private Sex sex;

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String toString(){
        return this.name+","+this.age+"岁,"+this.sex;
    }
}

enum Sex1{
    Man,Woman;
}

//public class Exer{
//    public static void main(String[] args) {
//        switch(Sex1.Man){//枚举支持switch判断
//            case Man:
//                System.out.println("男人");
//                break;
//            case Woman:
//                System.out.println("女人");
//                break;
//            default:
//                break;
//        }
//        Person per = new Person("lin",4,Sex.FEMALE);
//        System.out.println(per);
//        System.out.println(Color.getInsatance(Color.BLUE_NUMBER));
//        System.out.println(Colors.BLUE);
//        for(Colors color:Colors.values()){//返回枚举对象数组
//            System.out.println(color.ordinal()+"->"+color.name());//返回枚举对象下标与名称
//        }
//        IColor color = Colors.BLUE;
//        color.print();
//        System.out.println(color.toString());
//        System.out.println(color);
//    }
//}

//JDK1.8之后对接口的扩充
//interface IMessage{
//    public default void fun(){//支持default定义的普通方法
//        System.out.println("IMessage fun");
//    }
//    public static IMessage getInstance(){//支持static定义的静态方法
//        return new MessageImpl();
//    }
//    void print();
//}
//
//class MessageImpl implements IMessage{
//    public void print(){
//        System.out.println("Override print");
//    }
//}
//
//public class Exer{
//    public static void main(String[] args) {
//        IMessage message = IMessage.getInstance();
//        message.fun();
//        message.print();
//        System.out.println(message);
//    }
//}

interface IMessage{
    void print();
}
interface JiSuan{
    int add(int x,int y);
}

public class Exer{
    public static void main(String[] args) {
//        IMessage message = new IMessage() {//匿名内部类
//            @Override
//            public void print() {
//                System.out.println("hello");
//            }
//        };
        //Lambda表达式->函数式编程
//        IMessage message = () -> System.out.println("hello");//(参数) -> 单行语句
//        IMessage message = () -> {
//            System.out.println("hello1");
//            System.out.println("hello2");
//            System.out.println("hello3");
//        };//(参数) -> {多行语句}
//        message.print();
        JiSuan sum = (p1,p2) -> p1+p2;//单行语句省略return
        System.out.println(sum.add(2,4));
        JiSuan sum1 = (p1,p2) -> {
            p1 += 1;
            p2 += 2;
            return p1+p2;
        };
        System.out.println(sum1.add(1,2));
    }
}