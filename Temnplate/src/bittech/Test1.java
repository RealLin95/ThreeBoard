package bittech;

interface IComputer{
    void buyComputer();
}

class Macbook implements IComputer{

    @Override
    public void buyComputer() {
        System.out.println("买Macbook");
    }
}

class Surface implements IComputer{

    @Override
    public void buyComputer() {
        System.out.println("买Surface");
    }
}

//class ComputerFactory{//工厂方法模式的一般实现
//    public static IComputer getInstance(String str){
//        if(str!=null){
//            if(str.equals("Macbook")){
//                return new Macbook();
//            }else if(str.equals("Surface")){
//                return new Surface();
//            }
//        }
//        return null;
//    }
//}

class ComputerFactory{//利用反射创建新对象
    public static IComputer getInstance(String str){
        try {
            Class<?> cls = Class.forName(str);
            IComputer computer = (IComputer) cls.newInstance();
            return computer;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
public class Test1 {
    public static void main(String[] args) {
        IComputer computer = ComputerFactory.getInstance("bittech.Surface");
        computer.buyComputer();
    }
}
