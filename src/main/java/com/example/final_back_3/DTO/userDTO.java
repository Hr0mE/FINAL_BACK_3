package com.example.final_back_3.DTO;

import lombok.Data;
import org.springframework.data.relational.core.sql.In;

@Data
public class userDTO {
    private Integer id;
    private String login;
    private String password;
}
