package bittech;

public class EmpTest {
    public static void main(String[] args) throws Exception{
        String str = "emp.name:lin|emp.job:Coder";
        EmpAction empAction = new EmpAction();
        empAction.setEmpValue(str);
        System.out.println(empAction.getEmp());
    }
}
