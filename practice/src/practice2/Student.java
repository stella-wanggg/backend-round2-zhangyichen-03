package practice2;

import java.util.List;

public class Student {
    private String name;
    private List<Integer> scores;

    public boolean addScore(int score){
        if(score >= 0 && score <= 100){
            scores.add(score);
            return true;
        }
        return false;
    }

    public int getTotal(){
        int sum = 0;
        for(Integer score : scores){
            sum += score;
        }
        return sum;
    }

    public double getAverage(){
        if(getTotal() == 0){
            return 0.0;
        }
        double average = (double)getTotal()/(double) scores.size();
        return average;
    }

    public int getHighest() {
        if (scores.size() == 0){
            return 0;
        }
        int max = scores.get(0);
        for(int i = 1; i < scores.size(); i++){
            if(scores.get(i) > max){
                max = scores.get(i);
            }
        }
        return max;
    }

    public int getLowest(){
        if (scores.size() == 0){
            return 0;
        }
        int min = scores.get(0);
        for(int i = 1; i < scores.size(); i++){
            if(scores.get(i) < min){
                min = scores.get(i);
            }
        }
        return min;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getScores() {
        return scores;
    }


    public Student() {
    }

    public Student(String name, List<Integer> scores) {
        this.name = name;
        this.scores = scores;
    }

    @Override
    public String toString() {
        return  name + "  成绩="+ scores+
                "  平均="+getAverage() ;
    }
}


