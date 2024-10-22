package service.impl;

import entity.Course;
import dao.impl.DataManager;
import entity.CourseClass;
import entity.Student;

import java.util.ArrayList;
import java.util.Scanner;

import static utils.SimpleUtils.pressEnterToContinue;

public class CourseManager {
    public static void queryCourseInfo() {
        System.out.println("----------------------\t课程信息表\t----------------------");
        System.out.println("|\t课程编号\t|\t\t课程名称\t\t|\t学分\t|");
        ArrayList<Course> courses = DataManager.getCourses();
        for (Course course : courses) {
            System.out.println("|\t" + course.getCourse_id() + "\t|\t\t" + course.getCourse_name() + "\t\t|\t" + course.getCredit() + "\t|");
        }
        pressEnterToContinue();
    }

    public static void addCourses() {
        System.out.println("请输入要添加的课程数量：");
        Scanner scanner = new Scanner(System.in);
        int courseNum = scanner.nextInt();
        if (courseNum <= 0) {
            System.out.println("输入错误");
            return;
        }
        ArrayList<Course> courses = DataManager.getCourses();
        for (int i = 0; i < courseNum; i++) {
            System.out.println("请输入第" + (i+1) + "个课程名称：");
            String course_name = scanner.next();
            System.out.println("请输入第" + (i+1) + "个课程学分：");
            Double credit = scanner.nextDouble();
            System.out.println("请输入第" + (i+1) + "个课程编号：");
            String course_id = scanner.next();
            Course course = new Course(course_id,course_name, credit);
            courses.add(course);
        }

    }
    public static void deleteCourses() {
        System.out.println("请输入要删除的课程编号：");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        ArrayList<Course> courses = DataManager.getCourses();
        for (Course course : courses) {
            if (course.getCourse_id().equals(id)) {

//                //将对应的课程班级也删除
//                ArrayList<CourseClass> courseClasses = DataManager.getCourseClasses();
//                for (CourseClass courseClass : courseClasses) {
//                    if (courseClass.getCourse().equals(course)) {
//                        //删除对应教学班
//                        courseClasses.remove(courseClass);
//                        //删除该对应教学班中学生信息
//                        for(Student student:courseClass.getStudents()){
//                            student.getCourses().remove(course);
//                            student.getCourseClasses().remove(courseClass);
//                            student.getCourseScores().remove(course);
//                            student.getCourseClassHashMap().remove(course);
//
//                        }
//
//                    }
//                }

//                //将学生选课信息中对应的课程也删除
//                ArrayList<Student> students = DataManager.getStudents();
//                for (Student student : students) {
//                    for (int i = 0; i < student.getCourses().size(); i++) {
//                        if (student.getCourses().get(i).equals(course)) {
//                            student.getCourses().remove(course);
//                            student.getCourseClasses().remove(course);
//                        }
//                    }
//                }
                courses.remove(course);

                System.out.println("删除成功");
                System.out.println("删除的课程："+course);
                pressEnterToContinue();
                return;
            }
        }
    }
    public static void updateCourse() {
        System.out.println("请输入要修改的课程编号：");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        ArrayList<Course> courses = DataManager.getCourses();

        for (Course course : courses) {
            if (course.getCourse_id().equals(id)) {
                System.out.println("请输入要修改的课程名称：");
                String name = scanner.next();
                System.out.println("请输入要修改的课程学分：");
                Double credit = scanner.nextDouble();
                course.setCourse_name(name);
                course.setCredit(credit);
                System.out.println("修改成功");
                System.out.println("修改后的课程"+course);
                pressEnterToContinue();
                return;
            }
        }
        System.out.println("未找到对应课程");
        pressEnterToContinue();
    }
}
