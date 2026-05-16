import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call(){
        int sum = 0;
        for(int i =0;i<30;i++){
            sum += i;
        }
        return sum;
    }
}
