public class InsufficientBalanceException extends Exception {
    private double currentBalance;
    private double requestedAmount;

    public InsufficientBalanceException(String message, Throwable cause, double currentBalance, double requestedAmount) {
        super(message, cause);
        this.currentBalance = currentBalance;
        this.requestedAmount = requestedAmount;
    }

    @Override
    public String toString() {
        // 👇 关键优化：打印具体数值，面试时体现严谨性
        return "InsufficientBalanceException: " + getMessage() +
                " [当前余额: " + currentBalance + ", 请求金额: " + requestedAmount + "]";
    }
}