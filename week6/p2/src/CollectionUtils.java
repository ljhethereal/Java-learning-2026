import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class CollectionUtils {
    public static <T> void copy(List<? super T> dest, List<? extends T> src){
        for(T n: src){
            dest.add(n);
        }
    }

    public static <T> T findFirst(List<? extends T>list, Predicate<? super T> predicate){
        for(T n: list){
            if(predicate.test(n)){
                return n;
            }
        }
        return null;
    }

    public static <T> void forEach(List<? extends T> list, Consumer<? super T> consumer){
        for(T n: list){
            consumer.accept(n);
        }
    }

    public static <T, R> List<R> map(List<? extends T> list, Function<? super T, ? extends R> mapper){
        List<R> result = new ArrayList<>();
        for(T t: list){
            R r = mapper.apply(t);
            result.add(r);
        }
        return result;
    }

}
