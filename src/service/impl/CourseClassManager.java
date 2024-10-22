package service.impl;

import dao.impl.DataManager;
import entity.Course;
import entity.CourseClass;
import entity.Student;
import entity.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

import static utils.SimpleUtils.pressEnterToContinue;

public class CourseClassManager {
    public static void queryCourseClassInfo() {
        System.out.println("----------------------\t课程班级信息表\t----------------------");
        System.out.println("|\t教学班号\t\t|\t开课学期\t\t\t|\t学生总人数\t|\t老师姓名\t|\t课程名\t|");
        ArrayList<CourseClass> courseClasses = DataManager.getCourseClasses();
        for (CourseClass courseClass : courseClasses) {
            System.out.println("|\t" + courseClass.getClass_id() + "\t|\t" + courseClass.getSemester() + "\t\t|\t" + courseClass.getStudent_num() + "\t|\t" + courseClass.getTeacher().getName() + "\t|\t" + courseClass.getCourse().getCourse_name() + "\t|");
        }
        pressEnterToContinue();
    }
    public static void addCourseClasses() {
        System.out.println("请输入要添加的课程班级数量：");
        Scanner scanner = new Scanner(System.in);
        int courseClassNum = scanner.nextInt();
        if (courseClassNum <= 0) {
            System.out.println("输入错误");
            return;
        }
        ArrayList<CourseClass> courseClasses = DataManager.getCourseClasses();
        for (int i = 0; i < courseClassNum; i++) {
            System.out.println("请输入第" + (i+1) + "个教学班号：");
            String class_id = scanner.next();
            System.out.println("请输入第" + (i+1) + "个开课学期：");
            String semester = scanner.next();
            System.out.println("请输入第" + (i+1) + "个老师编号：");
            String teacher_id = scanner.next();
            System.out.println("请输入第" + (i+1) + "个课程编号：");
            String course_id = scanner.next();
            // 通过课程编号获取课程对象
            Course course = DataManager.getCourses().stream().filter(c -> c.getCourse_id().equals(course_id)).findFirst().orElse(null);
            // 通过教师编号获取教师对象
            Teacher teacher = DataManager.getTeachers().stream().filter(t -> t.getTeacher_id().equals(teacher_id)).findFirst().orElse(null);
            if(course == null) {
                System.out.println("输入的课程不存在");
                pressEnterToContinue();
                return;
            }
            if(teacher == null) {
                System.out.println("输入的教师不存在");
                pressEnterToContinue();
                return;
            }
            CourseClass courseClass = new CourseClass(class_id, semester, teacher, course);
            courseClasses.add(courseClass);
        }
        System.out.println("添加成功,添加" + courseClassNum + "个教学班级");
        System.out.println("添加的教学班级信息如下：");
        for (int i = 0; i < courseClassNum; i++) {
            System.out.println(courseClasses.get(courseClasses.size() - courseClassNum + i));
        }
        pressEnterToContinue();
    }
    public static void deleteCourseClasses() {
        System.out.println("请输入要删除的教学班号：");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        ArrayList<CourseClass> courseClasses = DataManager.getCourseClasses();
        for (CourseClass courseClass : courseClasses) {
            if (courseClass.getClass_id().equals(id)) {

//                //处理其他相关信息的数据
//                for (Student student : courseClass.getStudents()) {
//                    student.getCourseClasses().remove(courseClass);
//                }
                System.out.println("删除成功");
                System.out.println("删除的教学班级"+courseClass.getClass_id());
                courseClasses.remove(courseClass);
                pressEnterToContinue();
                return;
            }
        }
    }

    public static void updateCourseClass() {
        System.out.println("请输入要修改的教学班号：");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        ArrayList<CourseClass> courseClasses = DataManager.getCourseClasses();
        for (CourseClass courseClass : courseClasses) {
            if (courseClass.getClass_id().equals(id)) {
                System.out.println("请输入新的开课学期：");
                String newSemester = scanner.next();
                courseClass.setSemester(newSemester);
                System.out.println("修改成功");
                System.out.println("修改后的教学班级"+courseClass);
                pressEnterToContinue();
                return;
            }
        }
        System.out.println("未找到对应教学班级");
        pressEnterToContinue();
    }
}
