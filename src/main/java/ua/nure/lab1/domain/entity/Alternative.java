package ua.nure.lab1.domain.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Alternative extends Entity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Alternative(int id, String name) {
        this.name = name;
        super.setId(id);
    }

    public Alternative() {
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", getId())
                .append("name", name)
                .toString();
    }
}
