package entity;

public class Course {
    private String course_id; // 课程编号
    private String course_name; // 课程名称
    private Integer credit; // 学分

    private double regularScoreWeight = 0.1; // 平时成绩权重
    private double midtermScoreWeight = 0.2; // 期中成绩权重
    private double experimentScoreWeight = 0.3; // 实验成绩权重
    private double finalScoreWeight = 0.4; // 期末成绩权重

    public Course(String course_id, String course_name, Integer credit) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id='" + course_id + '\'' +
                ", course_name='" + course_name + '\'' +
                ", credit=" + credit +
                '}';
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

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }
}
