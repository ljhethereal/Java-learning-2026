//* 4. 工具类 PayrollSystem:
//        *    - 静态方法: void printPayroll(Employee[] staff)
// *      遍历数组，打印每位员工的 Info 和最终薪资。
//        *    - 静态方法: double getTotalCost(Employee[] staff)
// *      计算公司当月总人力成本。
public class PayrollSystem {
    public static void printPayroll(Employee[] staff){
        for(int i=0;i<staff.length;i++){
            System.out.println(staff[i].getInfo());
            System.out.println("final salary: "+staff[i].calcSalary());
        }
    }

    public static double getTotalCost(Employee[] staff){
        double sumCost=0;
        for(int i=0;i<staff.length;i++){
            sumCost += staff[i].calcSalary();
        }
        return sumCost;
    }
}
