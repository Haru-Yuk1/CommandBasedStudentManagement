package utils;

import entity.Course;

public class CourseInfo {
    //课程共有25门
    public static final Course[] COURSES = { // 记录课程信息
            new Course("MATH101", "高等数学", 3.5),
            new Course("MATH201", "线性代数", 3.0),
            new Course("STAT301", "概率与数理统计", 3.5),
            new Course("MATH301", "离散数学", 2.5),
            new Course("MATH401", "数值计算", 2.0),
            new Course("MATH501", "数学建模", 2.5),
            new Course("CS101", "计算机科学导论", 1.5),
            new Course("CS102", "程序设计", 3.5),
            new Course("CS202", "汇编语言", 3.0),
            new Course("CS301", "计算机组成原理", 3.5),
            new Course("CS302", "算法与数据结构", 4.0),
            new Course("CS401", "操作系统原理", 4.5),
            new Course("CS402", "软件工程", 2.5),
            new Course("CS501", "计算机网络与通信", 4.5),
            new Course("CS502", "编译原理", 2.0),
            new Course("CS601", "数据库系统原理", 4.5),
            new Course("CS701", "计算机图形学", 2.5),
            new Course("CS702", "人工智能", 5.0),
            new Course("CS801", "机器学习", 4.5),
            new Course("CS802", "深度学习", 4.5),
            new Course("CS901", "自然语言处理", 4.0),
            new Course("CS902", "计算机视觉", 5.0),
            new Course("CS1001", "计算机体系结构", 4.0),
            new Course("CS1002", "计算机安全", 2.0),
            new Course("CS1101", "计算机组网", 3.5),
    };
    public static final String[] SEMESTERS = {"2020-2021-1", "2020-2021-2", "2021-2022-1", "2021-2022-2",
            "2022-2023-1", "2022-2023-2", "2023-2024-1", "2023-2024-2", "2024-2025-1", "2024-2025-2","2025-2026-1", "2025-2026-2"
            , "2026-2027-1", "2026-2027-2", "2027-2028-1", "2027-2028-2"};

}
