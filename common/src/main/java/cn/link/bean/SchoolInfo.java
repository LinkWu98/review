package cn.link.bean;

/**
 * @author Link
 * @version 1.0
 * @date 2020/10/28 18:17
 */
public class SchoolInfo {

    public SchoolInfo(String schoolName, String profession) {
        this.schoolName = schoolName;
        this.profession = profession;
    }

    /**
     * 学校名称
     */
    private String schoolName;

    /**
     * 专业
     */
    private String profession;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "SchoolInfo{" +
                "schoolName='" + schoolName + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}
