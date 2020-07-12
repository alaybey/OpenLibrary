package model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table
public class User implements  IModel{

    public enum Role {

        USER, ADMIN;

    }

    @Id
    @Column()
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private short userId;

    @Column(unique = true, length = 16, updatable = false)
    private String username;

    @Column(length = 32, updatable = true)
    private String password;

    @Transient
    @Enumerated(EnumType.STRING)
    private Role role;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;


    public User(){
        //
    }

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public short getUserId() {
        return userId;
    }

    // setUserId

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", created=" + created +
                '}';
    }
}

