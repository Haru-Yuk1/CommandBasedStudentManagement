package entity;

public class Teacher extends Person {
    private String teacher_id; // 教师编号



    public Teacher(String name, String gender, Integer age, String teacher_id) {
        super(name, gender, age);
        this.teacher_id = teacher_id;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacher_id='" + teacher_id + '\'' +
                '}';
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }
}
