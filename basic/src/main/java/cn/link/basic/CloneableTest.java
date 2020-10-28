package cn.link.basic;

import cn.link.bean.SchoolInfo;
import cn.link.bean.Student;
import org.junit.Test;

/**
 * 深浅拷贝测试
 * <p>
 * 成员变量是引用类型时，浅拷贝共享地址值，深拷贝（成员变量也要实现clone）是各自独立的
 *
 * @author Link
 * @version 1.0
 * @date 2020/10/28 18:15
 */
public class CloneableTest {

    @Test
    public void test() throws CloneNotSupportedException {

        SchoolInfo school = new SchoolInfo("PKU", "计算机科学与技术");

        Student link = new Student("Link", school);

        Student zelda = (Student) link.clone();


        System.out.println(link);
        System.out.println(zelda);

        school.setSchoolName("CZU");
        System.out.println("======= 改变后成员变量后 =======");

        System.out.println(link);
        System.out.println(zelda);

    }

}
