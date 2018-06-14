package ua.nure.lab1.domain.entity;

public class User extends Entity{
    private String userName;
    private Role role;

    public User(int id, String userName, Role role) {
        setId(id);
        this.userName = userName;
        this.role = role;
    }

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
