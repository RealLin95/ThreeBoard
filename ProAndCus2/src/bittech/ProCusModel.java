package bittech;
//单生产--单消费--一个商品
class Goods{

    private String goodsName;
    private int count;

    public synchronized void setGoods(String goodsName){
        if(count>0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.goodsName = goodsName;
        this.count++;
        System.out.println("生产"+toString());
        notify();
    }

    public synchronized void getGoods() {
        if(count<=0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.count--;
        System.out.println("消费"+toString());
        notify();
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsName='" + goodsName + '\'' +
                ", count=" + count +
                '}';
    }

}

class Producer implements Runnable{

    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        this.goods.setGoods("纪梵希圣诞礼盒");
    }

}

class Consumer implements Runnable{

    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        this.goods.getGoods();
    }

}

public class ProCusModel {
    public static void main(String[] args) {
        Goods goods = new Goods();
        Producer producer = new Producer(goods);
        Consumer consumer = new Consumer(goods);
        Thread threadPro = new Thread(producer);
        Thread threadCus = new Thread(consumer);
        threadCus.start();
        threadPro.start();
    }
}
