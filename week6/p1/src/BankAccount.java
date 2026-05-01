import java.util.ArrayList; // 👈 必须导入
import java.util.List;

public class BankAccount {
    private String accountNo;
    private double balance;
    private String owner;
    private List<String> transactionLog; // 👈 声明

    public BankAccount(String accountNo, String owner, double initialBalance) {
        this.accountNo = accountNo;
        this.owner = owner;

        // 👇 关键修复：必须初始化列表，否则 add 会报空指针
        this.transactionLog = new ArrayList<>();

        if (initialBalance < 0) {
            throw new InvalidAccountException(406, "the initial balance can't be negative ", null);
        }
        balance = initialBalance;
        this.transactionLog.add("账户创建，初始余额: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new InvalidAccountException(400, "the deposit must be more than 0 ", null);
        balance += amount;
        transactionLog.add("存款: +" + amount);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) throw new InvalidAccountException(400, "the withdraw must be more than 0 ", null);
        if (amount > balance) {
            // 👇 关键修复：传入当前余额和请求金额，方便调试
            throw new InsufficientBalanceException("the amount must be less than balance ", null, balance, amount);
        }
        balance -= amount;
        transactionLog.add("取款: -" + amount);
    }

    public void transfer(BankAccount target, double amount) throws InsufficientBalanceException {
        if (target == null) throw new InvalidAccountException(406, "the account can't be null ", null);

        // 👇 关键修复：如果是同一个对象，才报错。原代码写反了！
        if (this == target) throw new InvalidAccountException(406, "the account can't be itself ", null);

        this.withdraw(amount);
        try {
            target.deposit(amount);
        } catch (Exception e) {
            // 简单回滚
            this.balance += amount;
            throw new RuntimeException("the deposit failed: " + e.getMessage(), e);
        }
        transactionLog.add("转账给 " + target.owner + ": -" + amount);
    }

    public String getTransactionHistory() {
        if (transactionLog == null || transactionLog.isEmpty()) {
            return "无交易记录";
        }
        // 👇 关键修复：用换行符连接，更清晰
        return String.join("\n", this.transactionLog);
    }

    public String getAccountNo() {
        return accountNo;
    }

    public double getBalance() {
        return balance;
    }
}