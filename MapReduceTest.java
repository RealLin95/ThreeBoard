package bittech;

import java.util.ArrayList;
import java.util.List;

class Goods{
    private String name;
    private Integer count;
    private Double price;

    public Goods(String name, Integer count, Double price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

public class MapReduceTest {
    public static void main(String[] args) {
        List<Goods> list = new ArrayList<>();
        //添加购物车
        list.add(new Goods("Mac",10,170.0));
        list.add(new Goods("YSL",10,320.0));
        list.add(new Goods("Dior",10,320.0));
        list.add(new Goods("TF",10,400.0));
        Double allPrice = list.stream().map(obj -> obj.getCount()*obj.getPrice())
                .reduce((sum,x) -> sum+x).get();
        System.out.println(allPrice);
    }
}
