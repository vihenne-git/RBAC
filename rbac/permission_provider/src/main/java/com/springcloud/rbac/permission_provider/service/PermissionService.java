package com.springcloud.rbac.permission_provider.service;

import com.springcloud.rbac.auth.DTO.PermissionDTO;
import com.springcloud.rbac.auth.PO.Permission;
import com.springcloud.rbac.auth.PO.User;

import java.util.List;

/**
 * @Author asus
 * @create 26/7/2020 下午2:10
 */
public interface PermissionService {
    /**
     *
     *
     * @description: 添加权限。
     * @param {User} user
     * @return: {boolean}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public boolean add(PermissionDTO permissionDTO);

    /**
     *
     *
     * @description: 用于删除权限。
     * @param {int} itemId
     * @return: {boolean}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public boolean remove(long id);

    /**
     *
     *
     * @description: 用于修改权限。
     * @param {FormItem} formItem
     * @return: {boolean}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public boolean edit(PermissionDTO permissionDTO);

    /**
     *
     *
     * @description: 用于删除权限。
     * @param {int} itemId
     * @return: {boolean}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public PermissionDTO selectById(long id);

    /**
     *
     *
     * @description: 用于查看权限列表。
     * @return: {String}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public List<PermissionDTO> list();



}
