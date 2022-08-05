package jhlz.code.test.entity;

/**
 * @author clf
 * @time 2022/8/5 17:27
 * @desc: 简单实体测试类
 */
public class User {
    private Long id;
    private String userName;

    public User() {
        id = 0L;
        userName = "0";
    }

    public User(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
