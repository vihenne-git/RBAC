package com.springcloud.rbac.auth.DTO;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springcloud.rbac.auth.PO.Role;
import com.springcloud.rbac.auth.PO.User;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @Author asus
 * @create 26/7/2020 下午1:33
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO implements Serializable {
    /**
     * 用户id
     */
    private long id;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 邮箱|登录帐号
     */
    private String email;

    /**
     * 密码
     */
    private String pswd;

    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 最后登录时间
     */
    private Date last_login_time;

    /**
     * 1:有效，0:禁止登录
     */
    private long status;

    public void transformToDTO (User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.pswd = user.getPswd();
        this.create_time = user.getCreate_time();
        this.last_login_time = user.getLast_login_time();
        this.status = user.getStatus();

    }

    public User getPO(){
        User user = new User();
        user.setId(this.id);
        user.setCreate_time(this.create_time);
        user.setEmail(this.email);
        user.setNickname(this.nickname);
        user.setLast_login_time(this.last_login_time);
        user.setPswd(this.pswd);
        return user;
    }
}
