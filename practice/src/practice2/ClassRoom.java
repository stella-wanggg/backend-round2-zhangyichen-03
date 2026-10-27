package practice2;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
    List<Student> students = new ArrayList<>();

    public void addStudent(Student s){
        students.add(s);
    }

    public Student findStudent(String name){
        for(Student student : students){
            if(student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }

    public double getClassAverge(){
        if(students.size() == 0){
            return 0.0;
        }
        double sum = 0.0;
        int num = 0;
        for(Student student : students){
            sum += student.getTotal();
            num += student.getScores().size();
        }
        double average = sum/num;
        return average;
    }

    public Student findTopStudent(){
        if (students.size() == 0){
            return null;
        }
        double max = students.get(0).getAverage();
        String maxName = students.get(0).getName();
        for(int i = 1; i < students.size(); i++){
            if(students.get(i).getAverage() > max){
                max = students.get(i).getAverage();
                maxName = students.get(i).getName();
            }
        }
        return findStudent(maxName);
    }

    public int countPassed(int passLine){
        if(students.size() == 0){
            return 0;
        }
        int num = 0;
        for(Student student : students){
            if(student.getAverage() >= passLine){
                num++;
            }
        }
        return num;
    }

    public void display(){
        System.out.println("-----========全体学生=======-----");
        for(Student student : students){
            System.out.println(student.getName());
        }
        System.out.println("平均分 : "+getClassAverge());
    }
}
