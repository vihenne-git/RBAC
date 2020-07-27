package com.springcloud.rbac.auth.DTO;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springcloud.rbac.auth.PO.Permission;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author asus
 * @create 26/7/2020 下午1:34
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PermissionDTO implements Serializable {

    /**
     * 权限id
     */
    private long id;

    /**
     * url地址
     */
    private String url;

    /**
     * url描述
     */
    private String name;

    /**
     *
     *
     * @description: 类型转换。
     * @param {Permission} permission
     * @return: {void}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public void transformToDTO (Permission permission) {
        this.id = permission.getId();
        this.name = permission.getName();
        this.url = permission.getUrl();
        permission =  null;
    }

    /**
     *
     *
     * @description: 类型转换。
     * @param {} null
     * @return: {Permission}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public Permission getPO(){
        Permission permission = new Permission();
        permission.setId(this.id);
        permission.setName(this.name);
        permission.setUrl(this.url);
        return permission;
    }
}
