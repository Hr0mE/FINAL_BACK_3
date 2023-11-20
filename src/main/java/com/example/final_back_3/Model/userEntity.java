package com.example.final_back_3.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

//Сущность пользователя с конструкторами, гетерами, сетерами
@Getter
@Setter
@Entity
@Data
public class userEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String login;
    private String password;

    public userEntity() {

    }

    public userEntity(Integer id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

