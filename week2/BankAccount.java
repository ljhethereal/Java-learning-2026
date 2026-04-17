/**
 * 题目：简易银行账户类设计
 * 要求：
 * 1. 定义类 BankAccount，属性：accountNo(String), ownerName(String), balance(double)
 * 2. 构造器：支持全参 + 仅账号+姓名（balance默认0.0）
 * 3. 方法：
 * - deposit(double amount): 存款，amount>0才生效，返回新余额
 * - withdraw(double amount): 取款，需判断余额充足+amount>0，不足抛IllegalArgumentException
 * - getBalance(): 返回余额（封装）
 * 4. 静态变量：totalAccounts 记录创建的账户总数
 * 5. main方法测试：创建2个账户，执行3次存取款，输出最终状态+总账户数
 * 交付要求：
 * - 代码文件：BankAccount.java + TestAccount.java
 * - 运行截图：展示异常触发场景（如透支取款）
 * - 思考题：为什么withdraw不直接返回boolean而选择抛异常？（复试高频）
 */
public class BankAccount {
    private String accountNo;
    private String ownerName;
    private double balance;

    private static int totalAccounts = 0;

    public BankAccount(String accountNo, String owerName, double balance) {
        if (balance < 0) throw new IllegalArgumentException("Initial balance can not be negative");
        this.accountNo = accountNo;
        this.ownerName = ownerName;
        this.balance = balance;

        totalAccounts++;
    }

    public BankAccount(String accountNo, String ownerName) {
        this(accountNo, ownerName, 0.0);
    }

    public double deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount number error");
        balance += amount;
        return (balance);
    }

    public double withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount number error");
        if (amount > balance) throw new IllegalArgumentException("Amount number must be littler than balance");
        balance -= amount;
        return balance;
    }

    @Override
    public String toString() {
        return "Account[No:" + accountNo + "Owner:" + ownerName + ", Balance:" + balance + "]";
    }

    public double getBalance() {
        return balance;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }
}