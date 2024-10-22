package entity;

import java.util.ArrayList;

public class CourseClass {
    private String class_id; // 教学班号
    private String semester; // 开课学期
    private Integer student_num; // 学生总人数

    private Teacher teacher; // 对应教师
    private Course course; // 对应课程
    private ArrayList<Student> students; // 学生列表

    public CourseClass(String class_id, String semester, Teacher teacher, Course course) {
        this.class_id = class_id;
        this.semester = semester;
        this.teacher = teacher;
        this.course = course;
        this.students=new ArrayList<>();
        this.student_num=0;
    }

    @Override
    public String toString() {
        return "教学班'"+class_id +"':{" +
                "开课学期='" + semester + '\'' +
                ", 学生总人数=" + student_num +
                ", 老师信息=" + teacher +
                ", 课程名='" + course.getCourse_name() + '\'' +
                "}\n";
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getStudent_num() {
        return student_num;
    }

    public void setStudent_num(Integer student_num) {
        this.student_num = student_num;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }
}
