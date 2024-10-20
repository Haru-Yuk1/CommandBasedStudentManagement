package dao.impl;

import entity.*;

import java.util.ArrayList;
import java.util.HashMap;

public class DataManager {
    protected static ArrayList<Student> students = new ArrayList<>(); // 记录所有学生信息
    protected static ArrayList<Teacher> teachers = new ArrayList<>(); // 记录所有教师信息
    protected static ArrayList<Course> courses = new ArrayList<>(); // 记录所有开课课程信息
    protected static ArrayList<CourseClass> courseClasses = new ArrayList<>(); // 记录所有教学班信息
//    protected static HashMap<Student, HashMap<Course, CourseScore>> studentScores = new HashMap<>(); //学生成绩

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void setStudents(ArrayList<Student> students) {
        DataManager.students = students;
    }

    public static ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public static void setTeachers(ArrayList<Teacher> teachers) {
        DataManager.teachers = teachers;
    }

    public static ArrayList<Course> getCourses() {
        return courses;
    }

    public static void setCourses(ArrayList<Course> courses) {
        DataManager.courses = courses;
    }

    public static ArrayList<CourseClass> getCourseClasses() {
        return courseClasses;
    }

    public static void setCourseClasses(ArrayList<CourseClass> courseClasses) {
        DataManager.courseClasses = courseClasses;
    }

//    public static HashMap<Student, HashMap<Course, CourseScore>> getStudentScores() {
//        return studentScores;
//    }
//
//    public static void setStudentScores(HashMap<Student, HashMap<Course, CourseScore>> studentScores) {
//        DataManager.studentScores = studentScores;
//    }
}

