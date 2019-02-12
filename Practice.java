import java.util.Scanner;
abstract class Same{
    final public void prepare(){
        boilWater();
        waterDrink();
        daoDrink();
        if(ifAdd()){
            addThing();
        }
    } 
    abstract public void waterDrink();
    abstract public void addThing();
    final public void boilWater(){
        System.out.println("把水烧开");
    }
    final public void daoDrink(){
        System.out.println("把喝的倒入杯中");
    }
    public boolean ifAdd(){
        return true;
    }
}
class Coffee extends Same{
    public void waterDrink(){
        System.out.println("冲咖啡");
    }
    public void addThing(){
        System.out.println("加糖");
    }
    public boolean ifAdd(){
        String answer = print();
        if(answer.equals("y")){
            return true;
        }return false;
    }
    public String print(){
        String answer = null;
        System.out.println("您想要加入糖吗？(y/n)");
        Scanner scanner = new Scanner(System.in);
        answer = scanner.nextLine();
        return answer;
    }
}
class Tea extends Same{
    public void waterDrink(){
        System.out.println("泡茶");
    }
    public void addThing(){
        System.out.println("加柠檬");
    }
}
public class Practice{
    public static void main(String[] args){
        Same coffee = new Coffee();
        coffee.prepare();
        Same tea = new Tea();
        tea.prepare();
    }
}