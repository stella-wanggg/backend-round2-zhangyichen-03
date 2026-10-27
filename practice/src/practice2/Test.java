package practice2;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){
        List<Integer> s1 = new ArrayList<>(List.of(90,80,70));
        List<Integer> s2 = new ArrayList<>(List.of(100,60));
        List<Integer> s3 = new ArrayList<>(List.of(50));
        Student st1 = new Student("张三",s1);
        Student st2 = new Student("李四",s2);
        Student st3 = new Student("王五",s3);
        ClassRoom classRoom = new ClassRoom();
        classRoom.addStudent(st1);
        classRoom.addStudent(st2);
        classRoom.addStudent(st3);
        System.out.println(classRoom.getClassAverge());
        System.out.println(classRoom.findTopStudent());
        System.out.println(classRoom.countPassed(60));
        System.out.println(st3.addScore(120));
        System.out.println(classRoom.findStudent("赵六"));
    }
}
