/* 定义一个抽象的"Role"类，有姓名，年龄，性别等成员变量 
1）要求尽可能隐藏所有变量(能够私有就私有,能够保护就不要公有)， 
再通过GetXXX()和SetXXX()方法对各变量进行读写。具有一个抽象的play()方法， 
该方法不返回任何值，同时至少定义两个构造方法。Role类中要体现出this的几种用法。*/
abstract class Role{
    private String name;
    private int age;
    private char sex;
    public static int high = 100;
    public abstract void play();
    public Role(String name,int age){
        this.setName(name);
        this.setAge(age);
    }
    public Role(String name,int age,char sex){
        this(name,age);            //this调用构造方法
        this.setSex(sex);          //this调用普通方法
    }
    public void setName(String name){
        this.name = name;          //this调用本类属性
    }
    public String getName(){
        return this.name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    public void setSex(char sex){
        this.sex = sex;
    }
    public char getSex(){
        return this.sex;
    }
    public void print(){
        System.out.println("父类print"+this);   //this表示当前对象
        System.out.println(this.getName());
        System.out.println(this.getAge());
        System.out.println(this.getSex());
    }
}
/*  2）从Role类派生出一个"Employee"类，该类具有Role类的所有成员（构造方法除外）， 
并扩展salary成员变量，同时增加一个静态成员变量“职工编号（ID）”。 
同样要有至少两个构造方法，要体现出this和super的几种用法，还要求覆盖play()方法， 
并提供一个final sing()方法。*/
class Employee extends Role{
    private int salary;
    public static String ID = "10011";
    public Employee(String name,int age,int salary){
        super(name,age);      //super调用父类构造方法
        this.salary = salary;
    }
    public Employee(String name,int age,char sex,int salary){
        this(name,age,salary);
        super.setSex(sex);
    }
    public void play(){
        super.print();
        System.out.println("子类play");   //super调用父类普通方法
        System.out.println(super.high);
    }
    public final void sing(){
        System.out.println("singing");
    }
}
/*3）"Manager"类继承"Employee"类，有一个final成员变量"vehicle" 
在main()方法中制造Manager和Employee对象,并测试这些对象的方法。 */ 
class Manager extends Employee{
    public static final String vehicle = "car"; 
    public Manager(String name,int age,char sex,int salary){
        super(name, age, sex, salary);
        System.out.println("孙子类构造方法");
    }
    public void play(){
        System.out.println("孙子类play");
    }
}
public class C{
    public static void main(String[] args){
        Employee e = new Employee("lin",4,'w',1000);
        e.play();
        e.sing();
        Manager m = new Manager("name", 10, 'w', 999);
        m.play();
        m.print();
    }
}