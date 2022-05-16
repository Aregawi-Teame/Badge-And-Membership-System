package com.membership.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Plan {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private boolean isLimited;
    private int qouta;
    @ManyToMany
    @JoinTable(name="Plan_Location",
            joinColumns = {@JoinColumn(name="Pla=n_id")},
            inverseJoinColumns = {@JoinColumn(name="Location_id")}
    )
    private Set<Location> locations;
    @OneToMany
    @JoinTable(name="Plan_Role",
            joinColumns = {@JoinColumn(name="Plan_id")},
            inverseJoinColumns = {@JoinColumn(name="Role_id")}
    )
    private Set<Role> roles;

    public Plan(int id, String name, String description, boolean isLimited, int qouta, Set<Location> locations, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isLimited = isLimited;
        this.qouta = qouta;
        this.locations = locations;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isLimited=" + isLimited +
                ", limit=" + qouta +
                ", roles=" + roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plan)) return false;
        Plan plan = (Plan) o;
        return getId() == plan.getId() && isLimited() == plan.isLimited() && getQouta() == plan.getQouta() && getName().equals(plan.getName()) && getDescription().equals(plan.getDescription()) && getRoles().equals(plan.getRoles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), isLimited(), getQouta(), getRoles());
    }
}
