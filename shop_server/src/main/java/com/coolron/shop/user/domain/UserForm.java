package com.coolron.shop.user.domain;/**
 * Created by Administrator on 2019/11/10.
 */

import lombok.Data;

/**
 * @Auther: xf
 * @Date: 2019/11/10 14:20
 * @Description:
 */
@Data
public class UserForm {
    private String username;
    private String password;
    private String email;
    private String mobile;
}
