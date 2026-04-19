//* 2. 子类 Manager (经理):
//        *    - 新增属性: bonus (double, 奖金)
// *    - 构造器: 全参 (name, baseSalary, bonus)，并在其中打印 "Manager 构造器被调用"
//        *    - 实现 calcSalary(): 返回 baseSalary + bonus
public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus){
        super(name, baseSalary);
        this.bonus = bonus;
        System.out.println("Manager 构造器被调用");
    }

    @Override
    public double calcSalary(){
        return baseSalary+bonus;
    }

}
