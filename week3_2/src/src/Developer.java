//* 3. 子类 Developer (程序员):
//        *    - 新增属性: hourlyRate (double, 时薪), hours (int, 工时)
//        *    - 构造器: 全参 (name, baseSalary, hourlyRate, hours)
// *      - 校验: 如果 hours > 168 (一周最大小时数)，抛 IllegalArgumentException("工时超标")
// *      - 打印: "Developer 构造器被调用"
//        *    - 实现 calcSalary(): 返回 baseSalary + hourlyRate * hours
public class Developer extends Employee {
    private double hourlyRate;
    private int hours;

    public Developer(String name, double baseSalary, double hourlyRate, int hours){
        super(name, baseSalary);
        if(hours > 168) throw new IllegalArgumentException("工时超标");
        this.hours = hours;
        this.hourlyRate = hourlyRate;
        System.out.println("Developer 构造器被调用");
    }

    @Override
    public double calcSalary(){
        return baseSalary + hourlyRate * hours;
    }
}
