package com.springcloud.rbac.role_provider.service;

import com.springcloud.rbac.auth.DTO.RoleDTO;
import com.springcloud.rbac.auth.DTO.Role_PermissionDTO;

import java.util.List;

/**
 * @Author asus
 * @create 26/7/2020 下午2:10
 */
public interface RoleService {
    /**
     *
     *
     * @description: 添加角色。
     * @param {User} user
     * @return: {boolean}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public boolean add(RoleDTO roleDTO);

    /**
     *
     *
     * @description: 用于删除角色。
     * @param {int} itemId
     * @return: {boolean}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public boolean remove(long id);

    /**
     *
     *
     * @description: 用于修改角色。
     * @param {FormItem} formItem
     * @return: {boolean}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public boolean edit(RoleDTO roleDTO);

    /**
     *
     *
     * @description: 用于ID查询角色。
     * @param {int} itemId
     * @return: {boolean}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public RoleDTO selectById(long id);

    /**
     *
     *
     * @description: 用于ID查询角色。
     * @param {int} itemId
     * @return: {boolean}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public Role_PermissionDTO selectRP_ById(long id);

    /**
     *
     *
     * @description: 用于查看角色列表。
     * @return: {String}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public List<RoleDTO> list();

    /**
     *
     *
     * @description: 为角色添加权限。
     * @param {User} user
     * @return: {boolean}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public boolean add_permission(long pid, long rid);

    /**
     *
     *
     * @description: 用于删除角色权限。
     * @param {int} itemId
     * @return: {boolean}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public boolean remove_permission(long pid,long rid);

}
