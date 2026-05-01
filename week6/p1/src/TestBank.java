public class TestBank {
    public static void main(String[] args) throws InsufficientBalanceException{
        BankAccount accA = new BankAccount("001", "A", 1000);
        BankAccount accB = new BankAccount("002", "B", 500);
        BankAccount accC = new BankAccount("003", "C", 100);
        BankAccount accD = new BankAccount("004", "D", 500);

        // ① 正常转账：A(1000) → B(500)，转账300
        System.out.println("===== ① 正常转账 =====");

        try {
            accA.transfer(accB, 300);
            System.out.println("转账成功");

        } catch (Exception e) {
            System.out.println("异常：" + e.getMessage());
            e.printStackTrace();
        }

        // ② 余额不足：C(100) → D(500)，转账200
        System.out.println("\n===== ② 余额不足转账 =====");

        try {
            accC.transfer(accD, 200);
        } catch (InsufficientBalanceException e) {
            System.out.println("捕获异常：余额不足 → " + e.getMessage());
            e.printStackTrace();
        }

        // ③ 金额为负：存款-100
        System.out.println("\n===== ③ 存款负数 =====");
        try {
            accA.deposit(-100);
        } catch (InvalidAccountException e) {
            System.out.println("捕获异常：金额非法 → " + e.getMessage());
            e.printStackTrace();
        }

        // ④ 目标账户为 null
        System.out.println("\n===== ④ 目标账户为null =====");
        try {
            accA.transfer(null, 100);
        } catch (InvalidAccountException e) {
            System.out.println("捕获异常：目标账户非法 → " + e.getMessage());
            e.printStackTrace();
        }

        // ⑤ 转账给自己
        System.out.println("\n===== ⑤ 转账给自己 =====");
        try {
            accA.transfer(accA, 100);
        } catch (InvalidAccountException e) {
            System.out.println("捕获异常：不能转账给自己 → " + e.getMessage());
            e.printStackTrace();
        }

        // 打印最终余额
        System.out.println("\n===== 最终余额 =====");
        System.out.println("账户A(" + accA.getAccountNo() + "): 余额 = " + accA.getBalance());
        System.out.println("账户B(" + accB.getAccountNo() + "): 余额 = " + accB.getBalance());
        System.out.println("账户C(" + accC.getAccountNo() + "): 余额 = " + accC.getBalance());
        System.out.println("账户D(" + accD.getAccountNo() + "): 余额 = " + accD.getBalance());

        // 打印交易历史（假设BankAccount类有相应的方法）
        System.out.println("\n===== 交易历史 =====");
        System.out.println("\n账户A 交易历史：");
        System.out.println(accA.getTransactionHistory());

        System.out.println("\n账户B 交易历史：");
        System.out.println(accB.getTransactionHistory());

        System.out.println("\n账户C 交易历史：");
        System.out.println(accC.getTransactionHistory());

        System.out.println("\n账户D 交易历史：");
        System.out.println(accD.getTransactionHistory());
    }

}
