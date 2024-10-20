package entity;

/**
 * 人员信息类
 */
public class Person {
    private String name; // 姓名
    private String gender; // 性别
    private Integer age; // 年龄


    //构造函数
    public Person(String name, String gender, Integer age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名='" + name + '\'' +
                ", 性别='" + gender + '\'' +
                ", 年龄=" + age;
    }

    //getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
