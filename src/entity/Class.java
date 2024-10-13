package entity;

public class Class {
    private String class_id; // 教学班号
    private String teacher_id; // 教师工号
    private String semester; // 开课学期
    private Integer student_num; // 学生人数
    private Teacher teacher; // 教师
    private Course course; // 课程

    public Class(String class_id, String teacher_id, String semester, Integer student_num, Teacher teacher, Course course) {
        this.class_id = class_id;
        this.teacher_id = teacher_id;
        this.semester = semester;
        this.student_num = student_num;
        this.teacher = teacher;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Class{" +
                "class_id='" + class_id + '\'' +
                ", teacher_id='" + teacher_id + '\'' +
                ", semester='" + semester + '\'' +
                ", student_num=" + student_num +
                ", teacher=" + teacher +
                ", course=" + course +
                '}';
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Integer getStudent_num() {
        return student_num;
    }

    public void setStudent_num(Integer student_num) {
        this.student_num = student_num;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
