package entity;

/*
* 学生信息类
*
* */

public class Student extends Person {

    private String Student_id;  // 学号
    private String major;       // 专业
    private String grade;       // 年级
    private String class_id;    // 班级


    //构造函数
    public Student(String name, String gender, Integer age, String student_id, String major, String grade, String class_id) {
        super(name, gender, age);
        Student_id = student_id;
        this.major = major;
        this.grade = grade;
        this.class_id = class_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Student_id='" + Student_id + '\'' +
                ", major='" + major + '\'' +
                ", grade='" + grade + '\'' +
                ", class_id='" + class_id + '\'' +
                '}';
    }

    //getter and setter
    public String getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(String student_id) {
        Student_id = student_id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }
}
