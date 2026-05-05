import java.util.List;
import java.util.ArrayList;

public class TestCollectoinjUtils {
    public static void main(String []args){
        System.out.println("===== 1. 协变测试（Integer → Number）=====");
        List<Integer> integerList = List.of(10, 20, 30);
        List<Number> numberList = new ArrayList<>();
        CollectionUtils.copy(numberList, integerList);
        System.out.println("拷贝后Number集合：" + numberList);

        System.out.println("\n===== 2. 逆变测试（String → Object）=====");
        List<String> stringList = List.of("Java", "泛型", "测试");
        List<Object> objectList = new ArrayList<>();
        CollectionUtils.copy(objectList, stringList);
        System.out.println("拷贝后Object集合：" + objectList);

        System.out.println("\n===== 3. Lambda查找第一个偶数 =====");
        List<Integer> numList = List.of(3, 5, 8, 9, 10);
        Integer firstEven = CollectionUtils.findFirst(numList, n -> n % 2 == 0);
        System.out.println("第一个偶数：" + firstEven);

        System.out.println("\n===== 4. 方法引用遍历集合 =====");
        List<Integer> printList = List.of(100, 200, 300);
        CollectionUtils.forEach(printList, System.out::println);

        System.out.println("\n===== 5. Integer转String集合 =====");
        List<Integer> intList = List.of(1, 2, 3, 4, 5);
        List<String> strList = CollectionUtils.map(intList, i -> "Num:" + i);
        System.out.println("转换后的String集合：" + strList);
    }

}
