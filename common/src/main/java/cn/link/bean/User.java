package cn.link.bean;

/**
 * 用户类
 *
 * @author Link
 * @version 1.0
 * @date 2020/10/22 12:25
 */
public class User {

    private String userId;

    private String name;

    private Integer age;

    private Integer status;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", status=" + status +
                '}';
    }
}
