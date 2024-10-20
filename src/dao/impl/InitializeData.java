package dao.impl;


import entity.Course;
import entity.CourseClass;
import entity.Student;
import entity.Teacher;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.max;
import static utils.CourseInfo.COURSES;
import static utils.CourseInfo.SEMESTERS;
import static utils.PersonName.*;
import static utils.SimpleUtils.pressEnterToContinue;

public class InitializeData {
    static Random random = new Random();


    public static void createStudents(ArrayList<Student> students, int studentNum) {
        System.out.println("开始初始化学生信息...");
        for (int i = 0; i < studentNum; i++) {
            String gender = setGender();
            String name = setName(gender);
            Integer age = random.nextInt(10) + 18;  // 年龄范围 18-27
            String grade = setGrade();
            // 将 i 格式化为四位定长的字符串作为学生的 ID
            String studentId = "";
            if (grade.equals("大一")) {
                studentId = "2024" + String.format("%04d", random.nextInt(studentNum) + 1);
            } else if (grade.equals("大二")) {
                studentId = "2023" + String.format("%04d", random.nextInt(studentNum) + 1);
            } else if (grade.equals("大三")) {
                studentId = "2022" + String.format("%04d", random.nextInt(studentNum) + 1);
            } else if (grade.equals("大四")) {
                studentId = "2021" + String.format("%04d", random.nextInt(studentNum) + 1);
            }


            Student student = new Student(name, gender, age, studentId, grade);

            students.add(student);
        }
        System.out.println("学生信息初始化完成,共初始化" + students.size() + "人");
//        System.out.println(students);
        pressEnterToContinue();
    }


    public static void createTeachers(ArrayList<Teacher> teachers, int teacherNum) {
        System.out.println("开始初始化教师信息...");
        for (int i = 0; i < teacherNum; i++) {
            String gender = setGender();
            String name = setName(gender);
            Integer age = random.nextInt(40) + 25;  // 年龄范围 25-65
            // 将 i 格式化为三位定长的字符串作为老师的 ID
            String teacherId = String.format("%03d", i + 1);

            Teacher teacher = new Teacher(name, gender, age, teacherId);

            teachers.add(teacher);
        }
        System.out.println("教师信息初始化完成，共初始化" + teachers.size() + "人");
//        System.out.println(teachers);
        pressEnterToContinue();
    }

    public static void createCourses(ArrayList<Course> courses, int courseNum) {
        System.out.println("开始初始化课程信息...");
        // 随机打乱课程列表
        ArrayList<Course> courseList = new ArrayList<>(Arrays.asList(COURSES));
        Collections.shuffle(courseList);
        for (int i = 0; i < courseNum && i < courseList.size(); i++) {
            Course course = courseList.get(i);
            courses.add(course);
        }

        System.out.println("课程信息初始化完成，共初始化" + courses.size() + "门课程");
//        System.out.println(courses);
        pressEnterToContinue();
    }

    //学生至少选三门课程，一个学生只能参加一个课程班级
    public static void studentChooseCourse(ArrayList<Student> students,ArrayList<Course> courses){
        System.out.println("开始初始化学生选课信息，正在随机分配课程...");
        for(Student student:students){
            int chooseCourseNum = random.nextInt(courses.size()-2)+3;  // 选课门数 3~courses.size()
            for (int i = 0; i < chooseCourseNum; i++) {
                Course course = courses.get(random.nextInt(courses.size()));
                // 如果学生已经选了这门课，重新选取
                if(student.getCourses().contains(course)){
                    i--;
                    continue;
                }
                course.setStudent_num(course.getStudent_num()+1);
                student.getCourses().add(course);
            }
        }
//        System.out.println("学生选课信息初始化完成，每个学生的选课列表：");
//        for (Student student : students) {
//            System.out.println(student.getName() + " : " + student.getCourses());
//        }
//        System.out.println("每门课程的学生人数：");
//        for (Course course:courses){
//            System.out.println(course.getCourse_name()+" : "+course.getStudent_num());
//        }
    }

    //一个课程至少两个教师，但不同课程的教师可以相同，也就是教师可以教多门课程，所以教师只有两名都行
    //由于设置了最大课程数，每个课程至少有40名
    public static void addCourseTeacher(ArrayList<Course> courses, ArrayList<Teacher> teachers) {
        // 根据课程学生数分配教师（教学班级）
        for (Course course : courses) {
            int studentNum = course.getStudent_num();
            int maxCourseClassNum = studentNum / 20;  // 最大教学班数
            ArrayList<Teacher> courseTeachers = new ArrayList<>();

            int teacherNum = random.nextInt(maxCourseClassNum-1) + 2;  // 教师数 2~maxCourseClassNum
            for (int i = 0; i < teacherNum; i++) {
                Teacher teacher = teachers.get(random.nextInt(teachers.size()));
                if (courseTeachers.contains(teacher)) {
                    i--;
                    continue;
                }
                courseTeachers.add(teacher);
            }
            course.setTeachers(courseTeachers);
        }
//        System.out.println("课程教师信息初始化完成,每门课程的老师列表：");
//        for (Course course : courses) {
//            System.out.println(course.getCourse_name() + " : " + course.getTeachers());
//        }
    }
    //为教学班添加学生，每个学生至少3个课程，一个学生只能参加一个课程班级
    public static void addCourseClassStudent(ArrayList<CourseClass> courseClasses, ArrayList<Student> students) {
        System.out.println("开始初始化教学班学生信息，正在随机分配学生...");

        int totalCount = 0;     //记录对应课程，当前分配的学生人数
        int classCount = 0;     //记录当前课程，第几个教学班
        // 根据学生所选课程分配教学班级
        for (CourseClass courseClass:courseClasses) {
            classCount+=1;

            Course course = courseClass.getCourse();    // 获取教学班对应的课程
            int classNum=course.getTeachers().size();   //获取教学班数
            ArrayList<Student> courseStudents = courseClass.getStudents();  // 获取教学班的学生列表
            int studentNum = course.getStudent_num();   // 获取该课程的学生总数



            int minNum=max(20,studentNum/classNum);
            int maxNum=studentNum-totalCount-(classNum-classCount)*minNum;
            if(totalCount<studentNum){

                int studentCount = random.nextInt(maxNum-minNum+1)+minNum; //
                totalCount += studentCount;
                outerLoop:
                for (int i = 0; i < studentCount; i++) {
                    Student student = students.get(random.nextInt(students.size()));    // 随机选取一个学生
                    // 如果该学生没选这门课
                    if(!student.getCourses().contains(course)){
                        i--;
                        continue;
                    }
                    // 如果该教学班的学生列表中已经包含了这个学生，重新选取
                    if (courseStudents.contains(student)) {
                        i--;
                        continue;
                    }
                    // 如果该学生已经选了其他教学班，重新选取
                    for(CourseClass courseClass1:student.getCourseClasses()){
                        if(courseClass1.getCourse().equals(course)){
                            i--;
                            continue outerLoop;
                        }
                    }

                    courseStudents.add(student);
                    student.getCourseClasses().add(courseClass);
                    student.getCourseClassHashMap().put(course,courseClass);
                }
                courseClass.setStudents(courseStudents);
            }
            // 如果当前是该课程的最后一个教学班，重置记录
            if(classCount==classNum){
                classCount=0;
                totalCount=0;
            }

        }

//        System.out.println("教学班学生信息初始化完成,每个教学班的学生列表：");
//        int count=0;
//        for (CourseClass courseClass:courseClasses){
//            courseClass.setStudent_num(courseClass.getStudents().size());
//            count+=courseClass.getStudents().size();
//            System.out.println("总共有"+courseClass.getStudent_num()+"个学生");
//            System.out.println(courseClass.getClass_id() + " : " + courseClass.getStudents());
//        }
//        System.out.println("总共有"+count+"个学生");
    }

    public static void createCourseClass(ArrayList<CourseClass> courseClasses, ArrayList<Course> courses) {
        System.out.println("开始初始化教学班信息，正在随机分配教师...");
        for(Course course:courses) {
            ArrayList<Teacher> teachers = course.getTeachers();
            int index=1;
            for(Teacher teacher:teachers) {
                String classId = course.getCourse_id() + String.format("-%02d", index);
                String semester = SEMESTERS[random.nextInt(SEMESTERS.length)];
                CourseClass courseClass =new CourseClass(classId, semester, teacher, course);
                index++;
                courseClasses.add(courseClass);
            }

        }
        // 为每个教学班随机分配学生
        addCourseClassStudent(courseClasses, DataManager.getStudents());
        System.out.println("教学班信息初始化完成，共" + courseClasses.size() + "个教学班");
//        System.out.println(courseClasses);
        pressEnterToContinue();
    }



    public static String setGender() {
        return random.nextInt(2) == 0 ? "男" : "女";
    }

    public static String setName(String gender) {
        String name = LAST_NAME_ARRAY[random.nextInt(LAST_NAME_ARRAY.length)];
        if (gender.equals("男")) {
            name += FIRST_NAME_MALE_ARRAY[random.nextInt(FIRST_NAME_MALE_ARRAY_LENGTH)];
        } else {
            name += FIRST_NAME_FEMALE_ARRAY[random.nextInt(FIRST_NAME_FEMALE_ARRAY_LENGTH)];
        }
        return name;
    }

    public static String setGrade() {
        String[] grade = {"大一", "大二", "大三", "大四"};
        return grade[random.nextInt(4)];
    }


    public static void InitStudentData(ArrayList<Student> students) {
        // 判断是否已经初始化学生信息
        if (!students.isEmpty()) {
            System.out.println("学生信息已经初始化，是否重新初始化？（Y/N）");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("N")) {
                return;
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生人数：(不少于100人，默认150人)");

        String input = scanner.nextLine();
        int studentNum = 0;
        if (input.isEmpty()) {
            createStudents(students, 150);
            return;
        }

        Pattern pattern = Pattern.compile("[0-9]*");  //
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            System.out.println("请输入正确的数字");
            return;
        }
        studentNum = Integer.parseInt(input);
        if (studentNum < 100) {
            System.out.println("学生人数不能小于100");
            return;
        }
        createStudents(students, studentNum);
    }

    public static void InitTeacherData(ArrayList<Teacher> teachers) {
        if (!teachers.isEmpty()) {
            System.out.println("教师信息已经初始化，是否重新初始化？（Y/N）");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("N")) {
                return;
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入教师人数：(不少于6人，默认10人)");

        String input = scanner.nextLine();
        int teacherNum = 0;
        if (input.isEmpty()) {
            createTeachers(teachers, 10);
            return;
        }
        Pattern pattern = Pattern.compile("[0-9]*");  //
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            System.out.println("请输入正确的数字");
            return;
        }
        teacherNum = Integer.parseInt(input);

        if (teacherNum < 6) {
            System.out.println("教师人数不能小于6");
            return;
        }
        createTeachers(teachers, teacherNum);
    }

    public static void InitCourseData(ArrayList<Course> courses) {
        if (!courses.isEmpty()) {
            System.out.println("课程信息已经初始化，是否重新初始化？（Y/N）");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("N")) {
                return;
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入课程门数：(不少于3门，最多25门，默认5门)");
        String input = scanner.nextLine();
        int courseNum = 0;
        if (input.isEmpty()) {
            createCourses(courses, 5);
            return;
        }
        Pattern pattern = Pattern.compile("[0-9]*");  //
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            System.out.println("请输入正确的数字");
            return;
        }
        courseNum = Integer.parseInt(input);

        if (courseNum < 3) {
            System.out.println("课程门数不能小于3");
            return;
        }
        createCourses(courses, courseNum);
    }

    public static void InitCourseClassData(ArrayList<CourseClass> courseClasses) {
        studentChooseCourse(DataManager.getStudents(),DataManager.getCourses());
        addCourseTeacher(DataManager.getCourses(), DataManager.getTeachers());
        createCourseClass(courseClasses, DataManager.getCourses());

    }

    public static void main(String[] args) {
        InitStudentData(DataManager.getStudents());
        InitTeacherData(DataManager.getTeachers());
        InitCourseData(DataManager.getCourses());
        InitCourseClassData(DataManager.getCourseClasses());

//        for(Student student:DataManager.getStudents()){
//            System.out.println(student+"学生对应班级"+student.getCourseClasses());
//        }
//
//        System.out.println("teachers"+DataManager.getTeachers());
//        System.out.println("courses"+DataManager.getCourses());
//        System.out.println("courseClasses"+DataManager.getCourseClasses());

    }
}
