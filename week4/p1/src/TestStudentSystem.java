import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class TestStudentSystem {
    public static void main(String[] args){
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(1,"a",90));
        list.add(new Student(2,"h",78));
        list.add(new Student(3,"p",69));
        list.add(new Student(4,"l",85));
        list.add(new Student(5,"c",92));

        //增加、
        list.add(new Student(6,"t",76));

        //search and decrease,search and change score
        Iterator<Student> it ;
        it= list.iterator();
        HashMap<Integer, Student> map = new HashMap<>();
        Student str;
        System.out.println("original list: ");
        while (it.hasNext()) {

            str = it.next();
            map.put(str.getId(), str);

            System.out.println(str);
            if(str.getId() == 3){
                it.remove();
            }
            if(str.getId() == 5){
                str.changeScore(88);
            }

        }

        //search for str by id
        Student str1 = map.get(3);
        System.out.println("the str's id is 3: "+ str1.toString());

        //sort

        Collections.sort(list);
        it = list.iterator();
        System.out.println("sorted list: ");
        while(it.hasNext()){
            str =it.next();

            System.out.println(str);
        }

        //sort by name
        Collections.sort(list, (s1,s2)->s1.name.compareTo(s2.name));
        it = list.iterator();
        System.out.println(" list sorted by name: ");
        while(it.hasNext()){
            str =it.next();

            System.out.println(str);
        }

        //search for str by id
        Student s = map.get(4);
        System.out.println("the student that his id is 4: "+s);
    }

}
