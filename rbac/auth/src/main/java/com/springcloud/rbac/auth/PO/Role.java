package com.springcloud.rbac.auth.PO;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * @Author asus
 * @create 26/7/2020 下午1:34
 */
@Data
@TableName("role")
public class Role {
    /**
     * 角色id
     */
    @TableId("id")
    private long id;

    /**
     * 角色名称
     */
    @TableField("name")
    private String name;

    /**
     * 角色类型
     */
    @TableField("type")
    private String type;
}
