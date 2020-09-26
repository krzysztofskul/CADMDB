package pl.krzysztofskul.user.userCategory;

import pl.krzysztofskul.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    private UserCategoryEnum userCategoryEnum;

    private String description;

    //@OneToMany(mappedBy = "userCategory")
    @ManyToMany(mappedBy = "userCategoryList")
    private List<User> userList = new ArrayList<>();

    public UserCategory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserCategoryEnum getUserCategoryEnum() {
        return userCategoryEnum;
    }

    public void setUserCategoryEnum(UserCategoryEnum userCategoryEnum) {
        this.userCategoryEnum = userCategoryEnum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void addUser (User user) {
        this.userList.add(user);
    }

    public void removeUser(User user) {
        this.userList.remove(user);
    }

}
