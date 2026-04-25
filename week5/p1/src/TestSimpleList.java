//* 3. TestSimpleList 测试类：
//        *    - 创建 SimpleList<String>，添加 3 个字符串，打印。
//        *    - 创建 SimpleList<Integer>，添加 3 个数字，打印。
//        *    - 演示泛型带来的好处：尝试添加错误类型 (如往 String 列表加 Integer) 看编译报错
public class TestSimpleList {
    public static void main (String[] args){
        SimpleList<String> s1 = new SimpleList<>();
        SimpleList<Integer> i1 = new SimpleList<>();

        s1.add("string1");
        s1.add("string2");
        s1.add("string3");

        i1.add(100);
        i1.add(200);
        i1.add(300);

        int temp =300;
        for(int i =0 ;i<20;i++){
            i1.add(temp + i*100);
        }


        System.out.println("-----print two list,see if the capacity of i1 is legal----");
        String res1=s1.toString();
        String res2 = i1.toString();
        System.out.println(res1);
        System.out.println(res2);

        System.out.println("-----print two list,see different functions----");
        System.out.println("find demo");
        System.out.println("for s1, the string whose index is 2 is:" + s1.get(2));
        System.out.println("size demo");
        System.out.println("for i1, the size is:" + i1.size());
        System.out.println("remove demo");
        System.out.println("for i1, after removing the number 10:" );
        i1.remove(9);
        String res3 = i1.toString();
        System.out.println(res3);

        System.out.println("-----print the first list,see the error information----");

    }


}
