/* class Person{
    private String name;
    private int age;
    public Person(){}
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
}
class Student{}
public class Day16{
    public static void main(String[] args){
        fun(new Person());
        fun(new Student());
        print(new Person("lin",4));
        print("hello");
    }
    public static void fun(Object obj){   //使用Object接受所有类对象
        System.out.println(obj);
    }
    public static void print(Object obj){
        System.out.println(obj.toString());  //默认Object类提供的toString()方法只能够得到对象的地址
    }
} */

/* class Person{
    private String name;
    private int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){   //通过覆写扩展toString()方法功能
        return "姓名"+this.name+","+"年龄"+this.age;
    }
}
class Student{}
public class Day16{
    public static void main(String[] args){
        String msg = "hello"+new Person("lin",4);
        fun(new Person("lin", 4));
        fun("hello");
        System.out.println(msg);             // 默认输出对象调用的就是toString()方法
    }
    public static void fun(Object obj){
        System.out.println(obj.toString());
    }
} */

/* class Person{
    private String name;
    private int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    // 覆写toString()方法，完成扩展功能
    public String toString(){
        return "姓名"+this.name+"，年龄"+this.age;
    }
    // 覆写equals()方法，完成对象的比较【内容相同】
    public boolean equals(Object obj){  //向上转型
        if(obj==null){
            return false;
        }else if(this==obj){ //地址相同
            return true;
        }else if(!(obj instanceof Person)){   //判断obj是否能指向person类,即是否可以完成向上转型
            return false;
        }
        Person per = (Person) obj;   //向下转型
        return per.name.equals(this.name)&&per.age==this.age;  //进行具体属性值的比较
    }
}
public class Day16{
    public static void main(String[] args){
        Person per1 = new Person("lin", 4);
        Person per2 = new Person("lin", 4);
        System.out.println(per1.equals(per2));
    }
} */

/* 使用Object接受数组对象 
public class Day16{
    public static void main(String[] args){
        Object obj = new int[]{1,2,3,4,5};   //向上转型
        int[] data = (int []) obj;    //向下转型，需要强转
        for(int x:data){
            System.out.print(x+"、");
        }
    }
} */

/* 使用Object接受接口对象 
interface IMessage{
    void getMseeage();
}
class MessageImpl implements IMessage{
    public String toString(){
        return "I am a biter";
    }
    public void getMseeage(){
        System.out.println("GetMessage");
    }
}
public class Day16{
    public static void main(String[] args){
        IMessage msg = new MessageImpl();   //子类向父接口转型
        Object obj = msg;    //接口向object转型
        // 以上两句等同于 Object obj = new MessageImpl(); 子类向Object转型
        System.out.println(obj);  //默认输出调用的是toSring()方法
        IMessage temp = (IMessage) obj;  // 向下转型，调用方法
        // 等同于 MessageImpl temp = (MessageImpl) obj;  //调用被覆写的方法
        temp.getMseeage();
    }
} */

/* 自己定义一个包装类 
class IntDemo{
    private int num;
    public IntDemo(int num){
        this.num = num;
    }
    public int intValue(){
        return this.num;
    }
}
public class Day16{
    public static void main(String[] args){
        Object obj = new IntDemo(5);  //向上转型，使用Object接受子类
        IntDemo temp = (IntDemo) obj;  //向下转型
        System.out.println(temp.intValue()); // 取出数据
    }
} */

/* 装箱与拆箱 */
public class Day16{
    public static void main(String[] args){
    /*  Integer num = new Integer(50);  // 装箱
        int data = num.intValue();  // 拆箱
        System.out.println(data); */

    /*  Integer x = 1;  // 自动装箱
        System.out.println(++x*5);  // 可以直接利用包装类对象操作 */

    /*  Integer data1 = new Integer(10);
        Integer data2 = new Integer(10);
        Integer num1 = 20;
        Integer num2 = 20;
        System.out.println(num1==num2);
        System.out.println(num1==new Integer(20));  //一个在常量池产生，一个在堆上产生
        System.out.println(num1.equals(num2));
        System.out.println(num1.equals(new Integer(20)));  //内容相同 */

        /* 将字符串变为int型 
        String str = "123";
        int num = Integer.parseInt(str);
        System.out.println(num+2); */

        /* 将字符串变为double型 
        String data = "123a";  //NumberFormatException异常，将字符串转为数字时，字符串的组成有非数字
        double num2 = Double.parseDouble(data);
        System.out.println(num2*2F); */

        /* 将字符串转为boolean类型 
        String str = "truess";
        boolean bol = Boolean.parseBoolean(str);
        System.out.println(bol); */

        /* 将基本数据类型变为字符串
        String str1 = String.valueOf(100);
        String str2 = String.valueOf(100.0);
        String str3 = String.valueOf('c');
        String str4 = String.valueOf(true);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4); */
        
    }
}