package de.hsba.a16.bi.mitfahrtszentrale.user;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
@Component
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.username = name;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

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
}
