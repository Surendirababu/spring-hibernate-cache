package com.suren.spring.hibernate.cache.hibernatecacheexample.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Surendirababu
 */

@Entity
@Table(name = "roledetail")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="role_name")
    private String roleName;

    @ManyToOne(cascade = CascadeType.ALL)
    User user;

    public Role() {
    }

    public Role(Integer id, String roleName, User user) {
        this.id = id;
        this.roleName = roleName;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (!id.equals(role.id)) return false;
        return roleName.equals(role.roleName);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + roleName.hashCode();
        return result;
    }
}
