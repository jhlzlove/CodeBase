package jhlz.code.entity;

/**
 * @author: jhlz
 * @since: 2022/11/13 14:25:19
 */
public class UserModel {
    private Long id;
    private String name;

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
}
