public class Mythread extends Thread{

    @Override
    public void run(){
        for(int i=0;i<30;i++){
            System.out.println(getName()+"hello world");
        }
    }
}
