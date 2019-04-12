package bittech;

//操作Emp类，最终提供给用户使用
//工具类

public class EmpAction {
    private Emp emp = new Emp();
    public void setEmpValue(String str) throws Exception{
        BeanUtil.setBeanValue(this,str);
    }
    //把设置好值的emp对象给用户返回回去
    public Emp getEmp(){
        return this.emp;
    }
}
