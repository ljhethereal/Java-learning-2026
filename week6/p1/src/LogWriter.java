public class LogWriter implements AutoCloseable{
    private String accountNo;

    public LogWriter(String accountNo){
        this.accountNo = accountNo;
    }

    public void write(String message){
        System.out.printf("账户[%s] 日志：%s%n", accountNo, message);
    }

    @Override
    public void close(){
        System.out.println("the stream of log has been closed");
    }
}
