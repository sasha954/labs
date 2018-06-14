package ua.nure.lab1.domain.entity;

public enum Role {

    USER(1),
    MODERATOR(2),
    ADMIN(3);

    private int value;

    Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Role getRole(int value) {
        for (Role role : values()) {
            if(role.value == value) {
                return role;
            }
        }
        return null;
    }
}
