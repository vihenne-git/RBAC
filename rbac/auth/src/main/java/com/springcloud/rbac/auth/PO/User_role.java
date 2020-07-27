package com.springcloud.rbac.auth.PO;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * @Author asus
 * @create 26/7/2020 下午1:57
 */
@Data
@TableName("user_role")
public class User_role {
    @TableId("id")
    private long id;

    @TableField("uid")
    private long uid;

    @TableField("rid")
    private long rid;
}
