public class TestAccount {
    public static void main(String[] args){

        //create two account
        BankAccount a1 = new BankAccount("a001","lu",10000);
        BankAccount a2 = new BankAccount("b001","hu",50);

        System.out.println("Lu deposits 500, now balance: " + a1.deposit(500));
        System.out.println("Lu withdraw 400, now balance: " + a1.withdraw(400));
        System.out.println("Hu deposits 1000, now balance: " + a2.deposit(1000));

        try{
            a1.withdraw(200);

        }catch(IllegalArgumentException e){
            System.out.println("Catch an exception: " + e.getMessage());
        }

        try{
            a1.withdraw(-50);

        }catch(IllegalArgumentException e){
            System.out.println("Catch an exception: " + e.getMessage());
        }

        System.out.println("\n=== 最终状态 ===");
        // 输出最终状态
        System.out.println(a1);
        System.out.println(a2);

        System.out.println("当前系统总账户数：" + BankAccount.getTotalAccounts());

    }
}
