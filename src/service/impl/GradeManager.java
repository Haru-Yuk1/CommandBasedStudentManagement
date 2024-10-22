package service.impl;

import dao.impl.DataManager;
import entity.Course;
import entity.CourseClass;
import entity.CourseScore;
import entity.Student;

import java.time.LocalDate;
import java.util.*;

import static utils.SimpleUtils.pressEnterToContinue;
import static utils.SortAscOrDesc.sortAscOrDesc;

public class GradeManager {
    static Random random = new Random();

    public static void getGrade(ArrayList<Student> students) {
        for (Student student : students) {
            for (Course course : student.getCourses()) {
                int regularGrade = random.nextInt(80) + 20;     // 平时成绩保底20，20-100
                int midtermGrade = random.nextInt(100);         //  期中成绩0-100
                int experimentGrade = random.nextInt(100);      //
                int finalGrade = random.nextInt(100);

//                String semester=student.getCourseClassHashMap().get(course).getSemester();
                CourseClass courseClass = student.getCourseClassHashMap().get(course);
                if (courseClass == null) {
                    continue;
                }
                String semester = courseClass.getSemester();
                int month = 0;
                int year = Integer.parseInt(semester.substring(0, 4));
                if (semester.charAt(semester.length() - 1) == '1') {
                    month = 9;

                } else if (semester.charAt(semester.length() - 1) == '2') {
                    month = 3;
                    year++;
                }
                LocalDate regularDate = LocalDate.of(year, month, random.nextInt(30) + 1);
                LocalDate midtermDate = LocalDate.of(year, month + 1, random.nextInt(30) + 1);
                LocalDate experimentDate = LocalDate.of(year, month + 2, random.nextInt(30) + 1);
                LocalDate finalDate = LocalDate.of(year, month + 3, random.nextInt(30) + 1);

//                int regularScore = (int) (regularGrade * course.getRegularScoreWeight());
//                int midtermScore = (int) (midtermGrade * course.getMidtermScoreWeight());
//                int experimentScore = (int) (experimentGrade * course.getExperimentScoreWeight());
//                int finalScore = (int) (finalGrade * course.getFinalScoreWeight());
//                int totalScore = regularScore + midtermScore + experimentScore + finalScore;

                int totalScore = (int) (regularGrade * course.getRegularScoreWeight() + midtermGrade * course.getMidtermScoreWeight()
                        + experimentGrade * course.getExperimentScoreWeight() + finalGrade * course.getFinalScoreWeight());


                CourseScore courseScore = new CourseScore(regularGrade, regularDate, midtermGrade, midtermDate,
                        experimentGrade, experimentDate, finalGrade, finalDate, totalScore);

                student.getCourseScores().put(course, courseScore);
            }
        }
        System.out.println("成绩初始化完成");
//        for (Student student : students) {
//            System.out.println("学生"+student.getStudent_id() + "," + student.getName() + "的成绩如下:" );
//            for (Course course : student.getCourses()) {
//                System.out.println("'"+course.getCourse_name() + "'：" + student.getCourseScores().get(course));
//            }
//
//        }
        pressEnterToContinue();
    }
    // 统计一个学生各科的总成绩
    public static void countTotalScore(){
        ArrayList<Student> students = DataManager.getStudents();
        System.out.println("统计学生各科总成绩");
        for(Student student:students){
            ArrayList<CourseClass> courseClasses=student.getCourseClasses();
            HashMap<Course,CourseScore> courseScores=student.getCourseScores();
            int total=0;
            for (CourseClass courseClass:courseClasses){
                total+=courseScores.get(courseClass.getCourse()).getComprehensiveScore();
            }
            student.setTotalScore(total);
        }
        System.out.println("学生各科总成绩统计完成");
//        for (Student student:students){
//            System.out.println("学生"+student.getStudent_id()+"各科总成绩为："+student.getTotalScore());
//        }
        pressEnterToContinue();
    }
    public static void queryScores(){
        ArrayList<Student> students=DataManager.getStudents();
        System.out.println("查询学生成绩");
        System.out.println("-------------------------------");
        System.out.println("所有学生成绩如下：");
        for (Student student:students){
            System.out.println("学生"+student.getStudent_id()+","+student.getName()+"的成绩如下：");
            for (Course course:student.getCourses()){
                System.out.println("课程"+course.getCourse_name()+":"+student.getCourseScores().get(course));
            }
            System.out.println("总成绩为："+student.getTotalScore());
        }
        pressEnterToContinue();

    }
    //查询一个教学班上的学生成绩
    public static void queryScoreByCourseClass_id() {
        ArrayList<CourseClass> courseClasses = DataManager.getCourseClasses();
        System.out.println("查询教学班成绩");
        System.out.println("-------------------------------");
        System.out.println("所有教学班号如下：");
        for (CourseClass courseClass : courseClasses) {
            System.out.println(courseClass.getClass_id());
        }
        System.out.println("请输入要查询的教学班号：");
        Scanner scanner = new Scanner(System.in);
        String class_id = scanner.nextLine();
        if (class_id.isEmpty()) {
            System.out.println("输入不能为空");
            return;
        }
        for (CourseClass courseClass : courseClasses) {
            if (courseClass.getClass_id().equals(class_id)) {
                System.out.println("选择按学号排序还是按成绩排序？");
                System.out.println("1.按学号排序");
                System.out.println("2.按学科综合成绩排序");
                System.out.println("请输入选择：");
//                int choice = scanner.nextInt();
//                //按学号，用sort+lambda表达式，这是升序
//                if (choice == 1) {
//                    courseClass.getStudents().sort((o1, o2) -> o1.getStudent_id().compareTo(o2.getStudent_id()));
//                }
//                //按学号，用sort+lambda表达式，这是降序
//                else if (choice == 2) {
//                    courseClass.getStudents().sort((o1, o2) -> o2.getStudent_id().compareTo(o1.getStudent_id()));
//                }
//                //按成绩，用sort+lambda表达式，这是升序
//                else if (choice == 3) {
//                    courseClass.getStudents().sort((o1, o2) -> o1.getCourseScores().get(courseClass.getCourse()).getComprehensiveScore() - o2.getCourseScores().get(courseClass.getCourse()).getComprehensiveScore());
//                }
//                //按成绩，用sort+lambda表达式，这是降序
//                else if (choice == 4) {
//                    courseClass.getStudents().sort((o1, o2) -> o2.getCourseScores().get(courseClass.getCourse()).getComprehensiveScore() - o1.getCourseScores().get(courseClass.getCourse()).getComprehensiveScore());
//                }
                int choice = scanner.nextInt();
                //按学号
                if (choice == 1) {
                    //用sort+lambda表达式，这是升序
                    if(sortAscOrDesc()==1) {
                        courseClass.getStudents().sort((o1, o2) -> o1.getStudent_id().compareTo(o2.getStudent_id()));
                    }
                    else {
                        courseClass.getStudents().sort((o1, o2) -> o2.getStudent_id().compareTo(o1.getStudent_id()));
                    }

                }
                else if (choice == 2) {
                    if(sortAscOrDesc()==1) {
                        courseClass.getStudents().sort((o1, o2) -> o1.getCourseScores().get(courseClass.getCourse()).getComprehensiveScore() - o2.getCourseScores().get(courseClass.getCourse()).getComprehensiveScore());
                    }
                    else {
                        courseClass.getStudents().sort((o1, o2) -> o2.getCourseScores().get(courseClass.getCourse()).getComprehensiveScore() - o1.getCourseScores().get(courseClass.getCourse()).getComprehensiveScore());
                    }
                }
                else {
                    System.out.println("输入错误");
                    return;
                }
                System.out.println("教学班" + courseClass.getClass_id() + "学生成绩表：");
                System.out.println("|\t学生学号\t|\t学生姓名\t|\t综合成绩\t|");
                for (Student student : courseClass.getStudents()) {
                    System.out.println("|\t"+student.getStudent_id() + "|\t" + student.getName() + "\t|\t" + student.getCourseScores().get(courseClass.getCourse()).getComprehensiveScore()+"\t\t|");
                }

                pressEnterToContinue();
                return;
            }
        }
        System.out.println("未找到该教学班号");
        pressEnterToContinue();


    }

    //统计学生各科、总成绩的分数段分布
    public static void countScoreDistribution() {
        ArrayList<Student> students = DataManager.getStudents();
        System.out.println("统计学生各科总成绩的分数段分布");
        System.out.println("-------------------------------");

        System.out.println("统计各科成绩分布");
        System.out.println("-------------------------------");
        for (Course course : DataManager.getCourses()) {
            String course_name = course.getCourse_name();
            int[] scoreDistribution = new int[10];
            for (Student student : students) {

                CourseScore courseScore=student.getCourseScores().get(course);
                if (courseScore==null){
                    continue;
                }
                int score=courseScore.getComprehensiveScore();
                if (score < 10) {
                    scoreDistribution[0]++;
                } else if (score < 20) {
                    scoreDistribution[1]++;
                } else if (score < 30) {
                    scoreDistribution[2]++;
                } else if (score < 40) {
                    scoreDistribution[3]++;
                } else if (score < 50) {
                    scoreDistribution[4]++;
                } else if (score < 60) {
                    scoreDistribution[5]++;
                } else if (score < 70) {
                    scoreDistribution[6]++;
                } else if (score < 80) {
                    scoreDistribution[7]++;
                } else if (score < 90) {
                    scoreDistribution[8]++;
                } else {
                    scoreDistribution[9]++;
                }
            }
            System.out.println(course_name + "课程，成绩分布如下：");
            System.out.println("0-9分：" + scoreDistribution[0] + "人");
            System.out.println("10-19分：" + scoreDistribution[1] + "人");
            System.out.println("20-29分：" + scoreDistribution[2] + "人");
            System.out.println("30-39分：" + scoreDistribution[3] + "人");
            System.out.println("40-49分：" + scoreDistribution[4] + "人");
            System.out.println("50-59分：" + scoreDistribution[5] + "人");
            System.out.println("60-69分：" + scoreDistribution[6] + "人");
            System.out.println("70-79分：" + scoreDistribution[7] + "人");
            System.out.println("80-89分：" + scoreDistribution[8] + "人");
            System.out.println("90-100分：" + scoreDistribution[9] + "人");
            System.out.println("-------------------------------");

        }
        pressEnterToContinue();
    }

    //通过名字或学号查询一个学生成绩
    public static void queryScoreByNameOrId(){
        System.out.println("通过名字或学号查询一个学生成绩");
        System.out.println("-------------------------------");
        System.out.println("请输入学生姓名或学号：");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            System.out.println("输入不能为空");
            return;
        }
        ArrayList<Student> students = DataManager.getStudents();
        for (Student student : students) {
            if (student.getName().equals(input) || student.getStudent_id().equals(input)) {
                System.out.println("学生" + student.getStudent_id()+","+student.getName() + "的成绩如下：");
                for (Course course : student.getCourses()) {
                    System.out.println(course.getCourse_name() + "：" + student.getCourseScores().get(course));
                }
                System.out.println("总成绩："+student.getTotalScore());
                pressEnterToContinue();
                return;
            }
        }
        System.out.println("未找到该学生");
        pressEnterToContinue();
    }
}
