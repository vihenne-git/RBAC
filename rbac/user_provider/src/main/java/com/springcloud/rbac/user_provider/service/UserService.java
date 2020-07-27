package com.springcloud.rbac.user_provider.service;

import com.springcloud.rbac.auth.DTO.Role_PermissionDTO;
import com.springcloud.rbac.auth.DTO.UserDTO;
import com.springcloud.rbac.auth.DTO.User_Role_PermissionDTO;
import com.springcloud.rbac.auth.PO.User;

import java.util.List;

/**
 * @Author asus
 * @create 26/7/2020 下午2:10
 */
public interface UserService {
    /**
     *
     *
     * @description: 添加用户。
     * @param {User} user
     * @return: {boolean}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public boolean add(UserDTO userDTO);

    /**
     *
     *
     * @description: 用于删除用户。
     * @param {int} itemId
     * @return: {boolean}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public boolean remove(long id);

    /**
     *
     *
     * @description: 用于修改用户。
     * @param {FormItem} formItem
     * @return: {boolean}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public boolean edit(UserDTO userDTO);

    /**
     *
     *
     * @description: 用于删除用户。
     * @param {int} itemId
     * @return: {boolean}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public UserDTO selectById(long id);

    /**
     *
     *
     * @description: 用于查看用户列表。
     * @return: {String}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public List<UserDTO> list();

    /**
     *
     *
     * @description: 为用户添加角色。
     * @param {User} user
     * @return: {boolean}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public boolean add_role(long uid, long rid);

    /**
     *
     *
     * @description: 用于删除用户角色。
     * @param {int} itemId
     * @return: {boolean}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public boolean remove_role(long uid,long rid);

    /**
     *
     *
     * @description: 用于ID查询角色。
     * @param {int} itemId
     * @return: {boolean}
     * @author: YuHangChen
     * @time: 14/7/2020 上午10:17
     */
    public User_Role_PermissionDTO selectURP_ById(long id);
}
