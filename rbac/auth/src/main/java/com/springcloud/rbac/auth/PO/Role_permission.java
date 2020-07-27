package com.springcloud.rbac.auth.PO;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * @Author asus
 * @create 26/7/2020 下午1:54
 */
@Data
@TableName("role_permission")
public class Role_permission {
    @TableId("id")
    private long id;

    @TableField("pid")
    private long pid;

    @TableField("rid")
    private long rid;
}
