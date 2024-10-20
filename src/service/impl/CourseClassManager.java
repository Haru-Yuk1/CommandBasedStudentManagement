package service.impl;

import dao.impl.DataManager;
import entity.Course;
import entity.CourseClass;
import entity.Student;

import java.util.ArrayList;
import java.util.Scanner;

import static utils.SimpleUtils.pressEnterToContinue;

public class CourseClassManager {
    public static void queryCourseClassInfo() {
        System.out.println("----------------------\t课程班级信息表\t----------------------");
        System.out.println("|\t教学班号\t|\t开课学期\t|\t学生总人数\t|\t老师信息\t|\t课程名\t|");
        ArrayList<CourseClass> courseClasses = DataManager.getCourseClasses();
        for (CourseClass courseClass : courseClasses) {
            System.out.println("|\t" + courseClass.getClass_id() + "\t|\t" + courseClass.getSemester() + "\t|\t" + courseClass.getStudent_num() + "\t|\t" + courseClass.getTeacher() + "\t|\t" + courseClass.getCourse().getCourse_name() + "\t|");
        }
        pressEnterToContinue();
    }
}
