package com.suren.spring.hibernate.cache.hibernatecacheexample.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by surendirababu
 */
@Entity
@Table(name = "userdetail")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="user_name")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    Set<Role> userRoles = new HashSet<>();

    public User(User user)
    {
        this.id=user.getId();
        this.userName=user.getUserName();
        this.password=user.getPassword();
        this.userRoles=user.getUserRoles();
        this.email=user.getEmail();

    }

    public User() {
    }

    public User(Integer id, String userName, String password, String email, Set<Role> userRoles) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userRoles = userRoles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<Role> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userRoles=" + userRoles +
                '}';
    }
}