import java.io.FileWriter;
import java.io.IOException;

public class BankService {

    public void processTransfer(BankAccount from, BankAccount to, double amount) {
        try (FileWriter writer = new FileWriter("transaction.log", true)) {

            from.withdraw(amount);
            to.deposit(amount);

            writer.write("转账成功：" + from.getAccountNo() + "->" + to.getAccountNo() + " 金额：" + amount + "\n");

        } catch (InsufficientBalanceException e) {
            throw new BusinessException(400, "转账失败：余额不足", e);
        } catch (InvalidAccountException e) {


            LogWriter logWriter = new LogWriter(from.getAccountNo());
            logWriter.write("转账参数非法：" + e.getMessage());

            throw e;
        } catch (IOException e) {
            throw new BusinessException(500, "日志文件写入失败", e);
        }
    }
}

class BusinessException extends RuntimeException {
    private int code;

    public BusinessException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}