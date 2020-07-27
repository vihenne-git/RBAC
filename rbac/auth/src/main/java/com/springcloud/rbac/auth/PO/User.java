package com.springcloud.rbac.auth.PO;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.sql.Date;

/**
 * @Author asus
 * @create 26/7/2020 下午1:33
 */
@Data
@TableName("user")
public class User {
    /**
     * 用户id
     */
    @TableId("id")
    private long id;

    /**
     * 用户昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 邮箱|登录帐号
     */
    @TableField("email")
    private String email;

    /**
     * 密码
     */
    @TableField("pswd")
    private String pswd;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date create_time;

    /**
     * 最后登录时间
     */
    @TableField("last_login_time")
    private Date last_login_time;

    /**
     * 1:有效，0:禁止登录
     */
    @TableField("status")
    private long status;
}
