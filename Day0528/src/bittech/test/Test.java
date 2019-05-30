package bittech.test;

public class Test {
    private static int x = 100;
    public static void main(String[] args) {
        Test test1 = new Test();
        test1.x++;
        Test test2 = new Test();
        test2.x++;
        test1 = new Test();
        test1.x++;
        Test.x--;
        System.out.println(x);
    }
}
