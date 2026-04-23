//* 5. TestStaff 测试类:
//        *    - 创建 1 个 Manager 和 2 个 Developer。
//        *    - 演示正常计算薪资。
//        *    - 演示传入非法工时（如 200 小时），捕获异常并提示。
//        *    - 输出总人力成本。
public class TestStaff {
    public static void main(String[] args){
        Employee[] mystaff = new Employee[3];
        mystaff[0] = new Manager("william", 2000,2000);
        mystaff[1] = new Developer("jone" , 3000,150,120);
        mystaff[2] = new Developer("Sam" , 2000,250,110);

        PayrollSystem.printPayroll(mystaff);
        System.out.println("total human cost: "+ PayrollSystem.getTotalCost(mystaff));

        Employee d3 = new Developer("Sam" , 2000,250,200);


    }
}
