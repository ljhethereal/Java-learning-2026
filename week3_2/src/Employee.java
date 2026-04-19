//1. 父类 Employee (抽象类):
//        *    - 属性: name (String), baseSalary (double)
//        *    - 构造器: 全参构造，并在其中打印 "Employee 构造器被调用"
//        *    - 抽象方法: double calcSalary()
// *    - 具体方法: String getInfo() 返回 "姓名: xxx, 基本薪资: xxx"
public abstract class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
        System.out.println("Employee 构造器被调用");
    }

    public abstract double calcSalary();

    public String getInfo(){
        return "name: "+name + ", basicSalary: "+baseSalary;
    }
}