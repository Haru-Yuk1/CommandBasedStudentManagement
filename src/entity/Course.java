package entity;

import java.util.ArrayList;
import java.util.Random;

/**
 * 表示课程及其详细信息，如课程编号、名称、学分、教师和成绩权重。
 */
public class Course {
    private String course_id; // 课程编号
    private String course_name; // 课程名称
    private Double credit; // 学分
    private ArrayList<Teacher> teachers; // 教师列表

    private Integer student_num = 0; // 学生选该课人数

    private double regularScoreWeight; // 平时成绩权重
    private double midtermScoreWeight; // 期中成绩权重
    private double experimentScoreWeight; // 实验成绩权重
    private double finalScoreWeight; // 期末成绩权重

    /**
     * 构造一个具有指定编号、名称和学分的新课程。
     *
     * @param course_id   课程编号
     * @param course_name 课程名称
     * @param credit      课程学分
     */
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

    /**
     * 返回课程的字符串表示形式。
     *
     * @return 课程的字符串表示形式
     */
    @Override
    public String toString() {
        return "课程'" + course_id + "'{" +
                "课程名='" + course_name + '\'' +
                ", 学分=" + credit +
                "}\n";
    }

    // 带有Javadoc注释的getter和setter方法

    /**
     * 获取课程编号。
     *
     * @return 课程编号
     */
    public String getCourse_id() {
        return course_id;
    }

    /**
     * 设置课程编号。
     *
     * @param course_id 课程编号
     */
    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    /**
     * 获取课程名称。
     *
     * @return 课程名称
     */
    public String getCourse_name() {
        return course_name;
    }

    /**
     * 设置课程名称。
     *
     * @param course_name 课程名称
     */
    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    /**
     * 获取课程学分。
     *
     * @return 课程学分
     */
    public Double getCredit() {
        return credit;
    }

    /**
     * 设置课程学分。
     *
     * @param credit 课程学分
     */
    public void setCredit(Double credit) {
        this.credit = credit;
    }

    /**
     * 获取教师列表。
     *
     * @return 教师列表
     */
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * 设置教师列表。
     *
     * @param teachers 教师列表
     */
    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    /**
     * 获取选课学生人数。
     *
     * @return 选课学生人数
     */
    public Integer getStudent_num() {
        return student_num;
    }

    /**
     * 设置选课学生人数。
     *
     * @param student_num 选课学生人数
     */
    public void setStudent_num(Integer student_num) {
        this.student_num = student_num;
    }

    /**
     * 获取平时成绩权重。
     *
     * @return 平时成绩权重
     */
    public double getRegularScoreWeight() {
        return regularScoreWeight;
    }

    /**
     * 设置平时成绩权重。
     *
     * @param regularScoreWeight 平时成绩权重
     */
    public void setRegularScoreWeight(double regularScoreWeight) {
        this.regularScoreWeight = regularScoreWeight;
    }

    /**
     * 获取期中成绩权重。
     *
     * @return 期中成绩权重
     */
    public double getMidtermScoreWeight() {
        return midtermScoreWeight;
    }

    /**
     * 设置期中成绩权重。
     *
     * @param midtermScoreWeight 期中成绩权重
     */
    public void setMidtermScoreWeight(double midtermScoreWeight) {
        this.midtermScoreWeight = midtermScoreWeight;
    }

    /**
     * 获取实验成绩权重。
     *
     * @return 实验成绩权重
     */
    public double getExperimentScoreWeight() {
        return experimentScoreWeight;
    }

    /**
     * 设置实验成绩权重。
     *
     * @param experimentScoreWeight 实验成绩权重
     */
    public void setExperimentScoreWeight(double experimentScoreWeight) {
        this.experimentScoreWeight = experimentScoreWeight;
    }

    /**
     * 获取期末成绩权重。
     *
     * @return 期末成绩权重
     */
    public double getFinalScoreWeight() {
        return finalScoreWeight;
    }

    /**
     * 设置期末成绩权重。
     *
     * @param finalScoreWeight 期末成绩权重
     */
    public void setFinalScoreWeight(double finalScoreWeight) {
        this.finalScoreWeight = finalScoreWeight;
    }
}