package com.springcloud.rbac.auth.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springcloud.rbac.auth.PO.User;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * @Author asus
 * @create 26/7/2020 下午4:27
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User_Role_PermissionDTO implements Serializable {
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

    /**
     * 用户权限
     */
    private List<Role_PermissionDTO> role_list;

    public void transform (User user ,List<Role_PermissionDTO> role_list) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.pswd = user.getPswd();
        this.create_time = user.getCreate_time();
        this.last_login_time = user.getLast_login_time();
        this.status = user.getStatus();
        this.role_list = role_list;
    }
}
