package entity;

import java.util.ArrayList;
import java.util.Random;

public class Course {
    private String course_id; // 课程编号
    private String course_name; // 课程名称
    private Double credit; // 学分
    private ArrayList<Teacher> teachers; // 教师列表

    private Integer student_num=0; // 学生选该课人数


    private double regularScoreWeight; // 平时成绩权重
    private double midtermScoreWeight; // 期中成绩权重
    private double experimentScoreWeight; // 实验成绩权重
    private double finalScoreWeight; // 期末成绩权重

    public Course(String course_id, String course_name, Double credit) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.credit = credit;
        this.teachers = new ArrayList<>();
        this.regularScoreWeight = 0.1;
        this.midtermScoreWeight = 0.2;
        this.experimentScoreWeight = 0.3;
        this.finalScoreWeight = 0.4;
    }

    @Override
    public String toString() {
        return "课程'"+course_id+"'{" +
                "课程名='" + course_name + '\'' +
                ", 学分=" + credit +
                "}\n";
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Integer getStudent_num() {
        return student_num;
    }

    public void setStudent_num(Integer student_num) {
        this.student_num = student_num;
    }

    public double getRegularScoreWeight() {
        return regularScoreWeight;
    }

    public void setRegularScoreWeight(double regularScoreWeight) {
        this.regularScoreWeight = regularScoreWeight;
    }

    public double getMidtermScoreWeight() {
        return midtermScoreWeight;
    }

    public void setMidtermScoreWeight(double midtermScoreWeight) {
        this.midtermScoreWeight = midtermScoreWeight;
    }

    public double getExperimentScoreWeight() {
        return experimentScoreWeight;
    }

    public void setExperimentScoreWeight(double experimentScoreWeight) {
        this.experimentScoreWeight = experimentScoreWeight;
    }

    public double getFinalScoreWeight() {
        return finalScoreWeight;
    }

    public void setFinalScoreWeight(double finalScoreWeight) {
        this.finalScoreWeight = finalScoreWeight;
    }
}
