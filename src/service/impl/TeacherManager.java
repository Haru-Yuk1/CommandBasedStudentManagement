package service.impl;

import dao.impl.DataManager;
import entity.Student;
import entity.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

import static utils.SimpleUtils.pressEnterToContinue;

public class TeacherManager {
    public static void queryTeacherInfo(){
        System.out.println("----------------------\t教师信息表\t----------------------");
        System.out.println("|\t教师编号\t|\t姓名\t\t|\t性别\t|\t年龄\t|");
        ArrayList<Teacher> teachers=DataManager.getTeachers();
        for (Teacher teacher : teachers) {
            System.out.println("|\t"+teacher.getTeacher_id()+"\t|\t"+teacher.getName()+"\t|\t"+teacher.getGender()+"\t|\t"+teacher.getAge()+"\t|");
        }
        pressEnterToContinue();
    }
    public static void addTeachers(){
        System.out.println("请输入要添加的教师数量：");
        Scanner scanner = new Scanner(System.in);
        int studentNum = scanner.nextInt();
        if (studentNum <= 0) {
            System.out.println("输入错误");
            return;
        }
        ArrayList<Teacher> teachers = DataManager.getTeachers();
        for (int i = 0; i < studentNum; i++) {
            System.out.println("请输入第" + (i+1) + "个教师姓名：");
            String name = scanner.next();
            System.out.println("请输入第" + (i+1) + "个教师性别：");
            String gender = scanner.next();
            System.out.println("请输入第" + (i+1) + "个教师年龄：");
            int age = scanner.nextInt();
            System.out.println("请输入第" + (i+1) + "个教师编号：");
            String teacher_id = scanner.next();
            Teacher teacher = new Teacher(name, gender, age, teacher_id);
            teachers.add(teacher);
        }
        System.out.println("添加成功,添加" + studentNum + "名教师");

    }
    public static void deleteTeachers(){
        System.out.println("请输入要删除的教师编号：");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        ArrayList<Teacher> teachers = DataManager.getTeachers();
        for (Teacher teacher : teachers) {
            if (teacher.getTeacher_id().equals(id)) {
                teachers.remove(teacher);
                System.out.println("删除成功");
                return;
            }
        }
    }
    public static void updateTeacher(){
        System.out.println("请输入要修改的教师编号：");
        Scanner scanner = new Scanner(System.in);
        String id1 = scanner.next();
        ArrayList<Teacher> teachers = DataManager.getTeachers();

        for (Teacher teacher1 : teachers) {
            if (teacher1.getTeacher_id().equals(id1)) {
                System.out.println("请输入要修改的教师姓名：");
                String name = scanner.next();
                System.out.println("请输入要修改的教师性别：");
                String gender = scanner.next();
                System.out.println("请输入要修改的教师年龄：");
                int age = scanner.nextInt();
                teacher1.setName(name);
                teacher1.setGender(gender);
                teacher1.setAge(age);
                System.out.println("修改成功");
                return;
            }
        }
    }

}
