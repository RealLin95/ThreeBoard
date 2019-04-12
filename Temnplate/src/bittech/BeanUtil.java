package bittech;

//操作简单类属性设置的工具类，基本都是工具方法

import java.lang.reflect.Method;

public class BeanUtil {
    private BeanUtil(){}
    //actionObj 拿到提供给用户使用的XXAction类
    //beanValue 要设置的具体值
    public static void setBeanValue(Object actionObj,String beanValue) throws Exception{
        //1.按每个属性先来拆分
        String[] temp = beanValue.split("\\|");
        for(int i = 0;i<temp.length;i++){
            //按照每个属性的（属性名、属性值）来拆分
            String[] result = temp[i].split(":");
            String realValue = result[1];
            //按照属性名（类名.属性名）来拆分
            String className = result[0].split("\\.")[0];//第一个元素为类名
            String attrName = result[0].split("\\.")[1];//拿到属性名
            //2.根据XXAction类取得真正操作的主题类，通过反射调用getEmp()
            Object realClass = getRealClass(actionObj,className);
            //3.通过反射，调用真正类的setter方法设置具体属性值
            Class<?> cls = realClass.getClass();
            //拼装具体属性的对应setXXX方法
            String setName = "set"+initCap(attrName);
            //取得并调用setXXX方法
            Method setMethod = cls.getMethod(setName,String.class);
            setMethod.invoke(realClass,realValue);
        }
    }

    private static Object getRealClass(Object actionObj,String className) throws Exception{
        //取得XXAction的Class对象
        Class<?> cls = actionObj.getClass();
        //拼装getXX()方法名称
        String methodName = "get"+initCap(className);
        //取得该方法名称的Method对象
        Method method = cls.getMethod(methodName);
        //通过反射调用该方法
        return method.invoke(actionObj);
    }

    private static String initCap(String str){
        return str.substring(0,1).toUpperCase()+
                str.substring(1);
    }
}
