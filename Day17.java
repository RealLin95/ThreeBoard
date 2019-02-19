package test;
/* 单例设计模式
class Singleton{
    private static Singleton single = new Singleton();   //2.在类的内部产生实例化对象(静态私有对象)
    private Singleton(){}    //1.构造方法私有化，表明外部无法调用无参构造，即不能产生新的实例化对象
    public static Singleton getInfo(){
        return single;                        //类内部提供静态方法返回唯一对象
    }
    public void print(){
        System.out.println("hello");
    }
}
public class Day17{
    public static void main(String[] args){
        Singleton s = Singleton.getInfo();
        s.print();
    }
} */

/* 饿汉单例模式（上来就new） 
class Singleton{
    private final static Singleton single = new Singleton();  // 2.final强调只能有一个实例化对象
    private Singleton(){}                  // 1.构造方法私有化
    public static Singleton getInfo(){      // 3.类内部提供静态方法返回唯一对象
        return single;
    }
    public void print(){
        System.out.println("hello 饿汉");
    }
}
public class Day17{
    public static void main(String[] args){
        Singleton single = Singleton.getInfo();  //调用静态方法取得唯一对象
        single.print();
    }
} */

/* 懒汉单例模式（用时再new） 
class Singleton{
    private static Singleton single;  //无需final
    private Singleton(){}           // 1.构造方法私有化
    public static Singleton getInfo(){   //3.静态方法返回唯一实例化对象
        if(single==null){
            single = new Singleton();  //2.判断是否实例化，若无实例化，便进行实例化
        }
        return single;
    }
    public void print(){
        System.out.println("hello 懒汉");
    }
}
public class Day17{
    public static void main(String[] args){
        Singleton single = Singleton.getInfo();  //通过静态方法取得对象
        single.print();
    }
} */

/* 多例设计模式 
class Sex{
    private String title;
    public static final int MALE_FLAG = 1;
    public static final int FEMALE_FLAG = 2;
    private static final Sex male = new Sex("男");    // 2.类内部提供实例化对象
    private static final Sex female = new Sex("女");
    private Sex(String title){    // 1.构造方法私有化
        this.title = title;
    }
    public static Sex getInfo(int flag){        // 3.静态方法返回实例化对象
        switch(flag){
            case MALE_FLAG:        
            return male;
            case FEMALE_FLAG:
            return female;
            default:
            return null;
        }
    }
    public String toString(){         // 4.覆写toString()方法
        return this.title;
    }
}
public class Day17{
    public static void main(String[] args){
        Sex sex = Sex.getInfo(1);  // 通过静态方法取得实例化对象
        System.out.println(sex);   // 默认调用toString()方法输出信息
    }
} */
