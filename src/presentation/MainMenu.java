package presentation;


import dao.impl.DataManager;
import dao.impl.InitializeData;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


import static dao.impl.InitializeData.*;

import static service.impl.CourseClassManager.queryCourseClassInfo;

import static service.impl.CourseManager.*;
import static service.impl.GradeManager.*;
import static service.impl.StudentManager.*;
import static service.impl.TeacherManager.*;
import static utils.CommandLineFont.*;

public class MainMenu extends DataManager {

    public static void show() {
        welcome();
        showTitle();
        showMainMenu();
    }

    // 欢迎
    public static void welcome() {

        String[] welcome = {
                " W     W  EEEEE  L      CCCCC  OOOOO  M     M  EEEEE ",
                " W     W  E      L     C      O     O M     M  E     ",
                " W  W  W  EEEE   L     C      O     O M  M  M  EEEE  ",
                "  W W W   E      L     C      O     O M M M M  E     ",
                "   W W    EEEEE  LLLLL  CCCCC  OOOOO  M     M  EEEEE "
        };
        System.out.println(ANSI_BLUE + "-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        for (String line : welcome) {
            System.out.println(line);
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------" + ANSI_RESET);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ANSI_BLUE + "-------------------------------");
        System.out.println("正在进入系统...");
        System.out.println("-------------------------------" + ANSI_RESET);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 清空控制台
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
    }

    // 显示系统名称
    public static void showTitle() {
        System.out.println(ANSI_BOLD + ANSI_GREEN + "-------------------------------");
        System.out.println("x x 大 学 学 生 成 绩 管 理 系 统");
        System.out.println("-------------------------------" + ANSI_RESET + ANSI_GREEN);

    }

    //显示主菜单
    public static void showMainMenu() {


        while (true) {

            System.out.println("主菜单");
            System.out.println("-------------------------------");
            System.out.println("\t\t1. 数据初始化");
            System.out.println("\t\t2. 获得各项成绩");
            System.out.println("\t\t3. 数据查询");
            System.out.println("\t\t4. 数据管理");
            System.out.println("\t\t5. 退出系统");
            System.out.println("-------------------------------");
            System.out.println("请选择您要进行的操作：(请输入对应数字)");


            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("请输入一个有效的整数！");
                scanner.next(); // 清除错误输入
                continue;
            }
            switch (choice) {
                case 1:
                    showInitDataMenu();
                    break;
//                case 2:
//                    showStudentChooseCourseMenu();
//                    break;
                case 2:
                    showGetGradeMenu();
                    break;
                case 3:
                    showDataQueryMenu();
                    break;
                case 4:
                    showDataManagerMenu();
                    break;
                case 5:
                    showExitSystem();
                    System.exit(0);
                    break;
                default:
                    System.out.println("请输入一个有效的选项！");
                    break;
            }
        }
    }

    // 显示数据初始化菜单
    public static void showInitDataMenu() {
        while (true) {
            // 清空控制台
            System.out.println(new String(new char[50]).replace("\0", "\r\n"));
            showTitle();
            System.out.println("数据初始化");
            System.out.println("-------------------------------");
            System.out.println("\t\t1. 生成学生数据");
            System.out.println("\t\t2. 生成教师数据");
            System.out.println("\t\t3. 生成课程数据");
            System.out.println("\t\t4. 生成教学班数据");
            System.out.println("\t\t5. 生成以上数据（一键默认生成）");
            System.out.println("\t\t6. 返回上级目录");
            System.out.println("-------------------------------");
            System.out.println("请选择您要初始化的数据：");

            Scanner scanner = new Scanner(System.in);

            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("请输入一个有效的整数！");
                scanner.next(); // 清除错误输入
            }

            switch (choice) {
                case 1:
                    System.out.println("-------------------------------");
                    System.out.println("初始化学生数据");
                    InitializeData.InitStudentData(DataManager.getStudents());

//                    InitializeData.InitStudentData(students);
                    break;
                case 2:
                    System.out.println("-------------------------------");
                    System.out.println("初始化教师数据");
                    InitializeData.InitTeacherData(DataManager.getTeachers());
                    break;
                case 3:
                    System.out.println("-------------------------------");
                    System.out.println("生成课程数据");
                    InitializeData.InitCourseData(DataManager.getCourses());
                    break;
                case 4:
                    System.out.println("-------------------------------");
                    System.out.println("生成教学班数据");
                    InitializeData.InitCourseClassData(DataManager.getCourseClasses());
                    break;
                case 5:
                    System.out.println("-------------------------------");
                    System.out.println("生成以上数据（一键生成）");
                    if (!students.isEmpty() || !teachers.isEmpty() || !courses.isEmpty() || !courseClasses.isEmpty()) {
                        System.out.println("信息已经初始化，是否重新初始化？（Y/N）");
                        String input = scanner.next();

                        if (input.equalsIgnoreCase("N")) {
                            return;
                        }
                        if (input.equalsIgnoreCase("Y")) {
                            students.clear();
                            teachers.clear();
                            courses.clear();
                            courseClasses.clear();
                        }
                    }
                    createStudents(students, 150);
                    createTeachers(teachers, 10);
                    createCourses(courses, 10);
                    InitializeData.InitCourseClassData(DataManager.getCourseClasses());
                    break;
                case 6:
                    System.out.println("返回上级目录");
                    return;
                default:
                    System.out.println("请输入一个有效的选项！");
                    break;

            }

        }

    }

    public static void showGetGradeMenu() {
        while (true) {
            // 清空控制台
            System.out.println(new String(new char[50]).replace("\0", "\r\n"));
            showTitle();
            System.out.println("获得成绩");
            System.out.println("-------------------------------");
            System.out.println("\t\t1. 获得各项成绩");
            System.out.println("\t\t2. 获得学生总成绩");
            System.out.println("\t\t3. 返回上级目录");
            System.out.println("-------------------------------");
            System.out.println("请选择您要进行的操作：");

            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("请输入一个有效的整数！");
                scanner.next(); // 清除错误输入
            }

            switch (choice) {
                case 1:
                    getGrade(DataManager.getStudents());
                    break;
                case 2:
                    countTotalScore();
                    break;
                case 3:
                    System.out.println("返回上级目录");
                    return;

                default:
                    System.out.println("请输入一个有效的选项！");
                    break;
            }
        }
    }

    public static void showDataQueryMenu() {
        while (true) {
            // 清空控制台
            System.out.println(new String(new char[50]).replace("\0", "\r\n"));
            showTitle();
            System.out.println("数据查询");
            System.out.println("-------------------------------");
            System.out.println("\t\t1. 查询学生信息");
            System.out.println("\t\t2. 查询教师信息");
            System.out.println("\t\t3. 查询课程信息");
            System.out.println("\t\t4. 查询教学班信息");
            System.out.println("\t\t5. 查询成绩信息");
            System.out.println("\t\t6. 返回上级目录");
            System.out.println("-------------------------------");
            System.out.println("请选择您要进行的操作：");

            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("请输入一个有效的整数！");
                scanner.next(); // 清除错误输入
            }

            switch (choice) {
                case 1:
                    showStudentInfoMenu();
                    break;
                case 2:
                    queryTeacherInfo();
                    break;
                case 3:
                    queryCourseInfo();
                    break;
                case 4:
                    showCourseClassInfoMenu();
                    break;
                case 5:
                    showScoreInfoMenu();
                    break;
                case 6:
                    System.out.println("返回上级目录");
                    return;

                default:
                    System.out.println("请输入一个有效的选项！");
                    break;
            }
        }
    }

    private static void showStudentInfoMenu() {
        while (true) {
            // 清空控制台
            System.out.println(new String(new char[50]).replace("\0", "\r\n"));
            showTitle();
            System.out.println("学生信息查询");
            System.out.println("-------------------------------");
            System.out.println("\t\t1. 查询所有学生信息");
            System.out.println("\t\t2. 按照学号排序学生");
            System.out.println("\t\t3. 按照总成绩排序学生");
            System.out.println("\t\t4. 按照各科成绩排序学生（排除未选该科学生）");
            System.out.println("\t\t5. 通过名字或学号查询学生成绩");
            System.out.println("\t\t6. 返回上级目录");
            System.out.println("-------------------------------");
            System.out.println("请选择您要进行的操作：");

            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("请输入一个有效的整数！");
                scanner.next(); // 清除错误输入
            }

            switch (choice) {
                case 1:
                    queryStudentInfo();
                    break;
                case 2:
                    queryStudentInfoById();
                    break;
                case 3:
                    queryStudentInfoByTotalScore();
                    break;
                case 4:
                    queryStudentInfoByCourseScore();
                    break;
                case 5:
                    queryScoreByNameOrId();
                    break;
                case 6:
                    System.out.println("返回上级目录");
                    return;

                default:
                    System.out.println("请输入一个有效的选项！");
                    break;
            }
        }
    }

    private static void showCourseClassInfoMenu() {
        while (true) {
            // 清空控制台
            System.out.println(new String(new char[50]).replace("\0", "\r\n"));
            showTitle();
            System.out.println("教学班信息");
            System.out.println("-------------------------------");
            System.out.println("\t1. 查询教学班信息");
            System.out.println("\t2. 查询一个教学班的学生成绩");
            System.out.println("\t3. 返回上级目录");
            System.out.println("-------------------------------");
            System.out.println("请选择您要进行的操作：");

            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("请输入一个有效的整数！");
                scanner.next(); // 清除错误输入
            }

            switch (choice) {
                case 1:
                    queryCourseClassInfo();
                    break;
                case 2:
                    queryScoreByCourseClass_id();
                    break;
                case 3:
                    System.out.println("返回上级目录");
                    return;

                default:
                    System.out.println("请输入一个有效的选项！");
                    break;
            }
        }
    }

    private static void showScoreInfoMenu() {
        while (true) {
            // 清空控制台
            System.out.println(new String(new char[50]).replace("\0", "\r\n"));
            showTitle();
            System.out.println("成绩信息");
            System.out.println("-------------------------------");
            System.out.println("\t1. 查询一个教学班的学生成绩");
            System.out.println("\t2. 统计学生各科总成绩的分数段分布");
            System.out.println("\t3. 通过名字或学号查询学生成绩");
            System.out.println("\t4. 返回上级目录");
            System.out.println("-------------------------------");
            System.out.println("请选择您要进行的操作：");

            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("请输入一个有效的整数！");
                scanner.next(); // 清除错误输入
            }

            switch (choice) {
                case 1:
                    queryScoreByCourseClass_id();
                    break;
                case 2:
                    countScoreDistribution();
                    break;
                case 3:
                    queryScoreByNameOrId();
                    break;
                case 4:
                    System.out.println("返回上级目录");
                    return;

                default:
                    System.out.println("请输入一个有效的选项！");
                    break;
            }
        }
    }

    public static void showDataManagerMenu() {
        while (true) {
            // 清空控制台
            System.out.println(new String(new char[50]).replace("\0", "\r\n"));
            showTitle();
            System.out.println("数据管理");
            System.out.println("-------------------------------");
            System.out.println("\t\t1. 学生管理");
            System.out.println("\t\t2. 教师管理");
            System.out.println("\t\t3. 课程管理");
            System.out.println("\t\t4. 教学班管理");
            System.out.println("\t\t5. 成绩管理");
            System.out.println("\t\t6. 返回上级目录");
            System.out.println("-------------------------------");
            System.out.println("请选择您要进行的操作：");

            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("请输入一个有效的整数！");
                scanner.next(); // 清除错误输入
            }

            switch (choice) {
                case 1:
                    showStudentManagerMenu();
                    break;
                case 2:
                    showTeacherManagerMenu();
                    break;
                case 3:
                    showCourseManagerMenu();
                    break;
                case 4:
                    showClassManagerMenu();
                    break;
                case 5:
                    showGradeManagerMenu();
                    break;
                case 6:
                    System.out.println("返回上级目录");
                    return;
                default:
                    System.out.println("请输入一个有效的选项！");
                    break;
            }
        }
    }

    public static void showStudentManagerMenu() {
        while (true) {
            // 清空控制台
            System.out.println(new String(new char[50]).replace("\0", "\r\n"));
            showTitle();
            System.out.println("学生信息查询");
            System.out.println("-------------------------------");
            System.out.println("\t\t1. 添加学生");
            System.out.println("\t\t2. 删除学生");
            System.out.println("\t\t3. 更改学生信息");
            System.out.println("\t\t4. 查询学生信息");
            System.out.println("\t\t5. 返回上级目录");
            System.out.println("-------------------------------");
            System.out.println("请选择您要进行的操作：");

            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("请输入一个有效的整数！");
                scanner.next(); // 清除错误输入
            }

            switch (choice) {
                case 1:
                    addStudents();
                    break;
                case 2:
                    deleteStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    queryStudentInfo();
                case 5:
                    System.out.println("返回上级目录");
                    return;

                default:
                    System.out.println("请输入一个有效的选项！");
                    break;
            }
        }
    }

    public static void showTeacherManagerMenu() {
        while (true) {
            // 清空控制台
            System.out.println(new String(new char[50]).replace("\0", "\r\n"));
            showTitle();
            System.out.println("教师管理");
            System.out.println("-------------------------------");
            System.out.println("\t\t1. 添加教师");
            System.out.println("\t\t2. 删除教师");
            System.out.println("\t\t3. 修改教师信息");
            System.out.println("\t\t4. 查询教师信息");
            System.out.println("\t\t5. 返回上级目录");
            System.out.println("-------------------------------");
            System.out.println("请选择您要进行的操作：");

            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("请输入一个有效的整数！");
                scanner.next(); // 清除错误输入
            }

            switch (choice) {
                case 1:
                    addTeachers();
                    break;
                case 2:
                    deleteTeachers();
                    break;
                case 3:
                    updateTeacher();
                    break;
                case 4:
                    queryTeacherInfo();
                    break;
                case 5:
                    System.out.println("返回上级目录");
                    return;
                default:
                    System.out.println("请输入一个有效的选项！");
                    break;
            }
        }
    }

    //课程管理
    public static void showCourseManagerMenu() {
        while (true) {
            // 清空控制台
            System.out.println(new String(new char[50]).replace("\0", "\r\n"));
            showTitle();

            System.out.println("课程管理");
            System.out.println("-------------------------------");
            System.out.println("\t\t1. 添加课程");
            System.out.println("\t\t2. 删除课程");
            System.out.println("\t\t3. 修改课程信息");
            System.out.println("\t\t4. 查询课程信息");
            System.out.println("\t\t5. 返回上级目录");
            System.out.println("-------------------------------");
            System.out.println("请选择您要进行的操作：");

            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("请输入一个有效的整数！");
                scanner.next(); // 清除错误输入
            }

            switch (choice) {
                case 1:
                    addCourses();
                    break;
                case 2:
                    deleteCourses();
                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("查询课程信息");
                    break;
                case 5:
                    System.out.println("返回上级目录");
                    return;
                default:
                    System.out.println("请输入一个有效的选项！");
                    break;
            }
        }
    }

    //教学班管理
    public static void showClassManagerMenu() {
        while (true) {
            // 清空控制台
            System.out.println(new String(new char[50]).replace("\0", "\r\n"));
            showTitle();

            System.out.println("教学班管理");
            System.out.println("-------------------------------");
            System.out.println("\t\t1. 添加教学班");
            System.out.println("\t\t2. 删除教学班");
            System.out.println("\t\t3. 修改教学班信息");
            System.out.println("\t\t4. 查询教学班信息");
            System.out.println("\t\t5. 返回上级目录");
            System.out.println("-------------------------------");
            System.out.println("请选择您要进行的操作：");

            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("请输入一个有效的整数！");
                scanner.next(); // 清除错误输入
            }

            switch (choice) {
                case 1:
                    System.out.println("添加教学班");
                    break;
                case 2:
                    System.out.println("删除教学班");
                    break;
                case 3:
                    System.out.println("修改教学班信息");
                    break;
                case 4:
                    System.out.println("查询教学班信息");
                    break;
                case 5:
                    System.out.println("返回上级目录");
                    return;
                default:
                    System.out.println("请输入一个有效的选项！");
                    break;
            }
        }
    }

    //成绩管理
    public static void showGradeManagerMenu() {
        while (true) {
            // 清空控制台
            System.out.println(new String(new char[50]).replace("\0", "\r\n"));
            showTitle();

            System.out.println("成绩管理");
            System.out.println("-------------------------------");
            System.out.println("\t\t1. 录入成绩");
            System.out.println("\t\t2. 修改成绩");
            System.out.println("\t\t3. 查询成绩");
            System.out.println("\t\t4. 返回上级目录");
            System.out.println("\t\t5. 退出系统");
            System.out.println("-------------------------------");
            System.out.println("请选择您要进行的操作：");

            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("请输入一个有效的整数！");
                scanner.next(); // 清除错误输入
            }

            switch (choice) {
                case 1:
                    System.out.println("录入成绩");
                    break;
                case 2:
                    System.out.println("修改成绩");
                    break;
                case 3:
                    System.out.println("查询成绩");
                    break;
                case 4:
                    System.out.println("返回上级目录");
                    return;
                default:
                    System.out.println("请输入一个有效的选项！");
                    break;
            }
        }
    }

    //退出系统
    public static void showExitSystem() {
        System.out.println("-------------------------------");
        System.out.println("正在退出系统...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        System.out.println("感谢您的使用！");
        System.out.println("-------------------------------");

        String[] thanks = {
                " TTTTT  H   H   A   N   N  K   K  SSSS ",
                "   T    H   H  A A  NN  N  K  K  S     ",
                "   T    HHHHH AAAAA N N N  KKK    SSS  ",
                "   T    H   H A   A N  NN  K  K      S ",
                "   T    H   H A   A N   N  K   K  SSSS "
        };

        System.out.println(ANSI_BLUE + "-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        for (String line : thanks) {
            System.out.println(line);
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------" + ANSI_RESET);
    }


}
