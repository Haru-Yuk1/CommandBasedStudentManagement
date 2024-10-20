package service.impl;

import entity.Course;
import dao.impl.DataManager;
import entity.CourseClass;

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
                //将对应的课程班级也删除
                ArrayList<CourseClass> courseClasses = DataManager.getCourseClasses();
                for (CourseClass courseClass : courseClasses) {
                    if (courseClass.getCourse().equals(course)) {
                        courseClasses.remove(courseClass);
                    }
                }
                courses.remove(course);

                System.out.println("删除成功");
                return;
            }
        }
    }
    public static void updateCourseById() {
        System.out.println("更新课程");
    }
}
