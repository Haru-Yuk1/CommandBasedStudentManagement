package service.impl;

import dao.impl.DataManager;
import entity.Course;
import entity.CourseClass;
import entity.CourseScore;
import entity.Student;

import java.util.ArrayList;
import java.util.Scanner;

import static utils.SimpleUtils.pressEnterToContinue;
import static utils.SortAscOrDesc.sortAscOrDesc;

public class StudentManager {
    public static void queryStudentInfo() {
        System.out.println("----------------------学生信息表----------------------");
        System.out.println("|\t学号\t\t\t|\t姓名\t\t|\t性别\t|\t年龄\t|\t年级\t|");
        ArrayList<Student> students = DataManager.getStudents();
        for (Student student : students) {
            System.out.println("|\t" + student.getStudent_id() + "\t|\t" + student.getName() + "\t|\t" + student.getGender() + "\t|\t" + student.getAge() + "\t|\t" + student.getGrade() + "\t|");
        }
        pressEnterToContinue();
    }

    public static void queryStudentInfoById() {
        int choice = sortAscOrDesc();
        if (choice == 0) {
            return;
        }

        System.out.println("----------------------学生信息表----------------------");
        System.out.println("|\t学号\t\t\t|\t姓名\t\t|\t性别\t|\t年龄\t|\t年级\t|");
        ArrayList<Student> students = DataManager.getStudents();
        if (choice == 1) {
            students.sort((o1, o2) -> o1.getStudent_id().compareTo(o2.getStudent_id()));
        } else if (choice == 2) {
            students.sort((o1, o2) -> o2.getStudent_id().compareTo(o1.getStudent_id()));
        } else {
            System.out.println("输入错误");
            return;
        }
        for (Student student : students) {
            System.out.println("|\t" + student.getStudent_id() + "\t|\t" + student.getName() + "\t|\t" + student.getGender() + "\t|\t" + student.getAge() + "\t|\t" + student.getGrade() + "\t|");
        }
        pressEnterToContinue();
    }

    public static void queryStudentInfoByTotalScore() {
        int choice = sortAscOrDesc();

        System.out.println("----------------------学生信息表----------------------");
        System.out.println("|\t学号\t\t\t|\t姓名\t\t|\t性别\t|\t年龄\t|\t总成绩\t|");
        ArrayList<Student> students = DataManager.getStudents();

        if (choice == 1) {
            students.sort((o1, o2) -> o1.getTotalScore().compareTo(o2.getTotalScore()));
        } else if (choice == 2) {
            students.sort((o1, o2) -> o2.getTotalScore().compareTo(o1.getTotalScore()));
        } else {
            return;
        }
        for (Student student : students) {
            System.out.println("|\t" + student.getStudent_id() + "\t|\t" + student.getName() + "\t|\t" + student.getGender() + "\t|\t" + student.getAge() + "\t|\t" + student.getTotalScore() + "\t|");
        }
        pressEnterToContinue();
    }

    //根据课程成绩排序学生信息
    public static void queryStudentInfoByCourseScore() {
        ArrayList<Student> students = DataManager.getStudents();
        ArrayList<Course> courses = DataManager.getCourses();
        System.out.println("所有课程号如下：");
        for (Course course : courses) {
            System.out.println(course.getCourse_id());
        }
        System.out.println("请输入要查询的课程号：");
        Scanner scanner = new Scanner(System.in);
        String class_id = scanner.nextLine();
        if (class_id.isEmpty()) {
            System.out.println("输入不能为空");
            return;
        }

        for (Course course : courses) {
            //判断输入的课程号是否存在
            if (course.getCourse_id().equals(class_id)) {
                int choice = sortAscOrDesc();
                //按照课程成绩排序
                if (choice == 1) {
                    students.sort((o1, o2) -> {
                        CourseScore score1 = o1.getCourseScores().get(course);
                        CourseScore score2 = o2.getCourseScores().get(course);
                        //如果学生没有该课程成绩，则不显示
                        if (score1 == null && score2 == null) return 0;
                        if (score1 == null) return -1;
                        if (score2 == null) return 1;
                        return score1.getComprehensiveScore() - score2.getComprehensiveScore();
                    });
                } else if (choice == 2) {
                    students.sort((o1, o2) -> {
                        CourseScore score1 = o1.getCourseScores().get(course);
                        CourseScore score2 = o2.getCourseScores().get(course);
                        if (score1 == null && score2 == null) return 0;
                        if (score1 == null) return 1;
                        if (score2 == null) return -1;
                        return score2.getComprehensiveScore() - score1.getComprehensiveScore();
                    });
                } else {
                    return;
                }
                System.out.println("|\t学号\t|\t姓名\t|\t" + course.getCourse_name() + "成绩\t|");
                for (Student student : students) {
                    for (int i = 0; i < student.getCourses().size(); i++) {
                        Course course1 = student.getCourses().get(i);
                        if (course1.getCourse_id().equals(class_id)) {
                            //如果学生没有该课程成绩，则不显示
                            if(student.getCourseScores().get(course1)==null) {
                                continue;
                            }
                            System.out.println("|\t" + student.getStudent_id() + "\t|\t" + student.getName() + "\t|\t" + student.getCourseScores().get(course1).getComprehensiveScore() + "\t|");
                        }
                    }
                }
                pressEnterToContinue();
                return;
            }

        }
        System.out.println("未找到该课程，请检查输入是否正确。");
        pressEnterToContinue();


    }

    public static void randomChooseCourse() {
        ArrayList<Student> students = DataManager.getStudents();
        ArrayList<CourseClass> courseClasses = DataManager.getCourseClasses();
        if (students.isEmpty()) {
            System.out.println("学生信息尚未初始化，请先初始化学生信息");
            pressEnterToContinue();
            return;
        }
        if (courseClasses.isEmpty()) {
            System.out.println("教学班信息尚未初始化，请先初始化教学班信息");
            pressEnterToContinue();
            return;
        }
        System.out.println("正在随机分配学生选课...");
        System.out.println("随机分配学生选课完成");
        pressEnterToContinue();
    }
    public static void queryStudentClassInfo() {


        ArrayList<Student> students = DataManager.getStudents();
        if (students.isEmpty()) {
            System.out.println("学生信息尚未初始化，请先初始化学生信息");
            pressEnterToContinue();
            return;
        }
        System.out.println("随机分配学生,下面是学生选课信息");
        System.out.println("\t学生学号\t学生姓名\t课程名\t教学班号");
        for (Student student : students) {
            System.out.print(student.getStudent_id() + "\t" + student.getName());
            for (int i = 0; i < student.getCourseClasses().size(); i++) {
                Course course = student.getCourses().get(i);
                System.out.print("\t" + course.getCourse_name());
                CourseClass courseClass = student.getCourseClasses().get(i);
                System.out.print("\t" + courseClass.getClass_id() + "\n");
            }
        }
        pressEnterToContinue();
    }

    public static void addStudents() {
        System.out.println("请输入要添加的学生数量：");
        Scanner scanner = new Scanner(System.in);
        int studentNum = scanner.nextInt();
        if (studentNum <= 0) {
            System.out.println("输入错误");
            return;
        }
        ArrayList<Student> students = DataManager.getStudents();
        ArrayList<Student> newStudents = new ArrayList<>();
        for (int i = 0; i < studentNum; i++) {
            System.out.println("请输入第" + (i+1) + "个学生姓名：");
            String name = scanner.next();
            System.out.println("请输入第" + (i+1) + "个学生性别：");
            String gender = scanner.next();
            System.out.println("请输入第" + (i+1) + "个学生年龄：");
            int age = scanner.nextInt();
            System.out.println("请输入第" + (i+1) + "个学生学号：");
            String student_id = scanner.next();
            System.out.println("请输入第" + (i+1) + "个学生年级：");
            String grade = scanner.next();
            Student student = new Student(name, gender, age, student_id, grade);
            students.add(student);
            newStudents.add(student);
        }

        System.out.println("添加成功,添加" + studentNum + "名学生");
        System.out.println("添加的学生信息如下：");
        for (Student student : newStudents) {
            System.out.println("学号：" + student.getStudent_id() + " 姓名：" + student.getName() + " 性别：" + student.getGender() + " 年龄：" + student.getAge() + " 年级：" + student.getGrade());
        }
        pressEnterToContinue();
    }

    public static void deleteStudents() {
        System.out.println("请输入要删除的学生学号：");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        ArrayList<Student> students = DataManager.getStudents();
        for (Student student : students) {
            if (student.getStudent_id().equals(id)) {

//                //删除教学班中该学生信息
//                ArrayList<CourseClass> courseClasses = DataManager.getCourseClasses();
//                for (CourseClass courseClass : courseClasses) {
//                    if (courseClass.getStudents().contains(student)) {
//                        for (Student student1 : courseClass.getStudents()) {
//                            if (student1.getStudent_id().equals(id)) {
//                                courseClass.setStudent_num(courseClass.getStudent_num() - 1);
//                                courseClass.getCourse().setStudent_num(courseClass.getCourse().getStudent_num() - 1);
//                                courseClass.getStudents().remove(student1);
//                            }
//                        }
//                    }
//                }
                //删除学生表中的学生
                students.remove(student);
                System.out.println("删除成功");
                System.out.println("删除的学生："+student.getName());
                pressEnterToContinue();
                return;
            }
        }
        System.out.println("未找到该学生，请检查输入是否正确。");
        pressEnterToContinue();
    }


    public static void updateStudent() {
        System.out.println("请输入要修改的学生学号：");
        Scanner scanner = new Scanner(System.in);
        String id1 = scanner.next();
        ArrayList<Student> students = DataManager.getStudents();
        for (Student student1 : students) {
            if (student1.getStudent_id().equals(id1)) {
                System.out.println("请输入修改后的学生姓名：");
                String name = scanner.next();
                System.out.println("请输入修改后的学生性别：");
                String gender = scanner.next();
                System.out.println("请输入修改后的学生年龄：");
                int age = scanner.nextInt();
                System.out.println("请输入修改后的学生年级：");
                String grade = scanner.next();
                student1.setName(name);
                student1.setGender(gender);
                student1.setAge(age);
                student1.setGrade(grade);
                System.out.println("修改成功");
                System.out.println("修改后的学生信息："+student1);
                pressEnterToContinue();
                return;
            }
        }
        System.out.println("未找到该学生，请检查输入是否正确。");
        pressEnterToContinue();

    }
}
