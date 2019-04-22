package bittech;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//真实业务接口
interface ISubject{
    void eat(String name,int count);
}

//真实业务类
class RealSubject implements ISubject{

    @Override
    public void eat(String name, int count) {
        System.out.println("eat"+count+"g"+name);
    }
}

//动态代理类
class ProxySubject implements InvocationHandler{
    //接受真实业务的对象
    private Object object;

    //用来绑定真实业务接口与代理类
    public Object bind(Object realObject){
        this.object = realObject;
        //返回绑定好的代理类对象
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.preHandle();
        //通过反射调用方法
        Object obj = method.invoke(this.object,args);//传入真实对象
        this.afterHandle();
        return obj;
    }

    public void preHandle(){
        System.out.println("处理前...");
    }

    public void afterHandle(){
        System.out.println("处理后...");
    }
}
public class Test {
    public static void main(String[] args) {
        ISubject subject = (ISubject) new ProxySubject().bind(new RealSubject());
        subject.eat("dumplings",500);
    }
}

