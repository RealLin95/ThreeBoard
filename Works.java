abstract class Role{
    private String name;
    private int age;
    private char sex;
    public abstract void play();
    public void setName(String name){
        this.name = name;
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
    public int getSex(){
        return this.sex;
    }
    public Role(String name){
        this.name = name;
    }
    public Role(String name,int age){
        this(name);
        this.age = age;
    }
    public Role(String name,int age,char sex){
        this(name,age);
        this.sex = sex;
    }
}

class Employee extends Role{
    private double salary;
    private static String id;
    public void play(){
        System.out.println("This is Employee play");
    }
    public final void sing(){
        System.out.println("This is Employee final");
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public double getSalary(){
        return this.salary;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public Employee(String name,int age,char sex,double salary){ //error
        super(name,age,sex);
        this.salary = salary;
    }
    public Employee(String name,int age,char sex,String id){
        super(name,age,sex);        
        this.id = id;
    }
}

class Manager extends Employee{
    public static final String vehicle = "Benz";//error
    public Manager(String name,int age,char sex,double salary){
        super(name,age,sex,salary);
    }
}

public class Works{
    public static void main(String args[]){
        Role rol = new Employee("lin",18,'w',100.1);
        rol.play();
        Manager man = new Manager("lin",18,'w',100.1);
        man.play();
        man.sing();
        System.out.println(Manager.vehicle);
    }
}