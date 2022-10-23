package jhlz.code.web.entity;

import java.time.LocalDateTime;

/**
 * @author clf
 * @time 2022/8/5 17:27
 * @desc: 简单实体测试类
 */
public class UserModel {
    private Long id;
    private String name;

    private LocalDateTime birthday;

    private Boolean sex;

    public UserModel() {
        id = 0L;
        name = "0";
    }

    public UserModel(Long id, String userName) {
        this.id = id;
        this.name = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                '}';
    }

    public Long getId() {
        return id;
    }

    public UserModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserModel setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public UserModel setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
        return this;
    }

    public Boolean getSex() {
        return sex;
    }

    public UserModel setSex(Boolean sex) {
        this.sex = sex;
        return this;
    }
}
