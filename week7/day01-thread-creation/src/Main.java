import java.util.concurrent.FutureTask;


public class Main {
    public static void main(String[] args) throws Exception{
        // 继承thread
//        Mythread t1 =new Mythread();
//        Mythread t2 =new Mythread();
//
//        t1.setName("t1: ");
//        t2.setName("t2: ");
//
//        t1.start();
//        t2.start();

//        // 调用runnable接口
//        Myrunnable r1 = new Myrunnable();
//        Myrunnable r2 = new Myrunnable();
//
//        Thread t1 = new Thread(r1);
//        Thread t2 = new Thread(r2);
//
//        t1.setName("t1:");
//        t2.setName("t2:");
//
//        t1.start();
//        t2.start();

        //调用callable和futuretask
        MyCallable m = new MyCallable();
        FutureTask<Integer> f = new FutureTask<>(m);
        Thread t = new Thread(f);

        t.start();
        System.out.println(f.get());
    }
}