package bittech.test;

class Test{
    public Test() {}


}

public class finalizeTest {
    public static finalizeTest test;
    public void isAlive(){
        System.out.println("I am Alive");
    }

    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("自救成功！");
        test = this;
    }
    public static void main(String[] args) throws InterruptedException {
        test = new finalizeTest();
        test = null;
        System.gc();
        Thread.sleep(1000);
        if(test!=null){
            test.isAlive();
        }else{
            System.out.println("自救失败！I am dead");
        }
        System.out.println("-------------------------------");
        test = null;
        System.gc();
        Thread.sleep(1000);
        if(test!=null){
            test.isAlive();
        }else{
            System.out.println("自救失败！I am dead");
        }
    }
}
