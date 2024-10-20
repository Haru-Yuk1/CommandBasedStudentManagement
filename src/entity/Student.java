package entity;

/*
* 学生信息类
*
* */

import java.util.ArrayList;
import java.util.HashMap;

public class Student extends Person {

    private String Student_id;  // 学号
    private String grade;       // 年级

    private ArrayList<Course> courses; // 所选课程列表
    private ArrayList<CourseClass> courseClasses; // 所选教学班列表
    private HashMap<Course,CourseClass> courseClassHashMap; // 课程对应教学班
    private HashMap<Course,CourseScore> courseScores; // 所有课程成绩

    private Integer totalScore=0;
    //构造函数

    public Student(String name, String gender, Integer age, String student_id, String grade) {
        super(name, gender, age);
        Student_id = student_id;
        this.grade = grade;
        this.courses = new ArrayList<>();
        this.courseClasses = new ArrayList<>();
        this.courseClassHashMap = new HashMap<>();
        this.courseScores = new HashMap<>();
    }

    @Override
    public String toString() {
        return "{" +
                "学号='" + Student_id + '\'' +
                ", 年级='" + grade + '\'' +
                ','+super.toString() +
                "}\n";
    }

    //getter and setter


    public String getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(String student_id) {
        Student_id = student_id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<CourseClass> getCourseClasses() {
        return courseClasses;
    }

    public void setCourseClasses(ArrayList<CourseClass> courseClasses) {
        this.courseClasses = courseClasses;
    }

    public HashMap<Course, CourseClass> getCourseClassHashMap() {
        return courseClassHashMap;
    }

    public void setCourseClassHashMap(HashMap<Course, CourseClass> courseClassHashMap) {
        this.courseClassHashMap = courseClassHashMap;
    }

    public HashMap<Course, CourseScore> getCourseScores() {
        return courseScores;
    }

    public void setCourseScores(HashMap<Course, CourseScore> courseScores) {
        this.courseScores = courseScores;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }
}
