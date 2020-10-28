package cn.link.bean;

/**
 * @author Link
 * @version 1.0
 * @date 2020/10/28 18:16
 */
public class Student implements Cloneable{

    private String name;

    private SchoolInfo schoolInfo;

    public Student(String name, SchoolInfo schoolInfo) {
        this.name = name;
        this.schoolInfo = schoolInfo;
    }

    /**
     * 浅拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Student student;
        student = (Student) super.clone();
        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", schoolInfo=" + schoolInfo +
                '}';
    }
}
