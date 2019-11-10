package com.coolron.shop.user.domain;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    private String mobile;

    private String email;

    private Date create_time;

    private Boolean mg_state;

    private String role_name;

}