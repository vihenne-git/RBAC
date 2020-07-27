package com.springcloud.rbac.auth.DTO;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springcloud.rbac.auth.PO.Permission;
import com.springcloud.rbac.auth.PO.Role;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author asus
 * @create 26/7/2020 下午1:34
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleDTO implements Serializable {
    /**
     * 角色id
     */
    private long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色类型
     */
    private String type;

    public void transformToDTO (Role role) {
        this.id = role.getId();
        this.name = role.getName();
        this.type = role.getType();
    }

    public Role getPO(){
        Role role = new Role();
        role.setId(this.id);
        role.setName(this.name);
        role.setType(this.type);
        return role;
    }
}
