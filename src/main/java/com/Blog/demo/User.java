package com.Blog.demo;


import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.GeneratorType;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long userId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;

    public User() {
    }

    public User(Long userId, String userFirstName, String userLastName, String userEmail) {
        this.userId=userId;
        this.userFirstName=userFirstName;
        this.userLastName=userLastName;
        this.userEmail=userEmail;


    }


}
