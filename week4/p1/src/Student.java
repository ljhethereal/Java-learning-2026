//* 1. 定义 Student 类：id(int), name(String), score(double)
// *    - 重写 toString(), equals(), hashCode()
// *    - 实现 Comparable<Student> 接口，按分数降序排序

import java.util.Objects;

public class Student implements Comparable<Student>{
    protected int id;
    protected String name;
    protected double score;

    public Student(int id, String name, double score){
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void changeScore(double score1){
        this.score = score1;
    }

    @Override
    public String toString(){
        return "the student's id is "+ id +" , the name is "+ name + " , the score is " + score;

    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id
                && Double.compare(score, student.score) ==0
                && Objects.equals(name, student.name);
    }
    @Override
    public int hashCode(){
        return Objects.hash(id, name, score);
    }

    @Override
    public int compareTo(Student o){
        return Double.compare(o.score, this.score);
    }
}