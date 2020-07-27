package com.springcloud.rbac.auth.PO;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.sql.Date;

/**
 * @Author asus
 * @create 26/7/2020 下午1:34
 */
@Data
@TableName("permission")
public class Permission {

    /**
     * 权限id
     */
    @TableId("id")
    private long id;

    /**
     * url地址
     */
    @TableField("url")
    private String url;

    /**
     * url描述
     */
    @TableField("name")
    private String name;
}
