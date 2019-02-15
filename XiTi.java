/*一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。例如6=1＋2＋3.编程 找出1000以内的所有完数。 
public class XiTi{
    public static void main(String[] args){
        for(int i = 1;i<=1000;i++){
            int sum = 0;      //每次判断下一个数，sum初始化为0
            for(int j = 1;j<=i/2;j++){
                if(0 == i%j){
                    sum += j;
                }
            }
            if(sum == i){        //找出所有因数相加之后，判断是否为“完数”
                System.out.println(i+"、");
            }
        }
    }
}
*/

/* 代理设计模式
interface IBuy{
    void buyComputer();
}
class RealIBuy implements IBuy{      //真实业务实现
    public void buyComputer(){
        System.out.println("买一台电脑");
    }
}
class FuZhuIBuy implements IBuy{
    private IBuy buy;  //真实的操作业务（通过接口对象完成）
    public FuZhuIBuy(IBuy buy){
        this.buy = buy;
    }
    public void buyComputer(){
        this.prepareBuy();
        this.buy.buyComputer();   //调用真实业务，此时IBuy buy = new RealIBuy();
        this.afterBuy();
    }
    public void prepareBuy(){
        System.out.println("买之前的准备工作");
    }
    public void afterBuy(){
        System.out.println("买之后的保修工作");
    }
}
class Factory{     //工厂类产生实例化对象
    public static IBuy getInfo(){
        return new FuZhuIBuy(new RealIBuy());  //调用辅助操作里的构造方法
    }
}
public class XiTi{
    public static void main(String[] args){
        IBuy buy = Factory.getInfo();
        buy.buyComputer();
    }
*/