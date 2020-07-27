package com.springcloud.rbac.auth.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springcloud.rbac.auth.PO.Permission;
import com.springcloud.rbac.auth.PO.Role;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author asus
 * @create 26/7/2020 下午4:28
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role_PermissionDTO implements Serializable {
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

    /**
     * 权限列表
     */
    private List<PermissionDTO> permission_list;


    public void transform (Role role,List<PermissionDTO> permission_list) {
        this.id = role.getId();
        this.name = role.getName();
        this.type = role.getType();
        this.permission_list = permission_list;
    }
}
