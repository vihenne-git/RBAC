package com.springcloud.rbac.role_provider.controller;

import com.springcloud.rbac.auth.DTO.RoleDTO;
import com.springcloud.rbac.auth.DTO.Role_PermissionDTO;
import com.springcloud.rbac.auth.util.ReturnResult;
import com.springcloud.rbac.role_provider.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author asus
 * @create 26/7/2020 下午1:59
 */
@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     *
     *
     * @description:查询角色
     * @param {RoleDTO} roleDTO
     * @return:ReturnResult
     * @author: YuHangChen
     * @time: 29/7/2020 上午11:01
     */
    @RequestMapping("/add")
    public ReturnResult add(@RequestBody RoleDTO roleDTO) {
        roleService.add(roleDTO);
        return ReturnResult.success(200,"添加角色成功","add item :" + roleDTO.getName());
    }

    /**
     *
     *
     * @description:删除角色
     * @param {RoleDTO} roleDTO
     * @return:ReturnResult
     * @author: YuHangChen
     * @time: 29/7/2020 上午11:01
     */
    @RequestMapping("/remove")
    public ReturnResult remove(@RequestBody RoleDTO roleDTO) {
        roleService.remove(roleDTO.getId());
        return ReturnResult.success(200,"删除角色成功","remove item :" + roleDTO.getName());
    }

    /**
     *
     *
     * @description: 修改角色
     * @param {RoleDTO} roleDTO
     * @return:ReturnResult
     * @author: YuHangChen
     * @time: 29/7/2020 上午11:01
     */
    @RequestMapping("/edit")
    public ReturnResult edit(@RequestBody RoleDTO roleDTO) {
        roleService.edit(roleDTO);
        return ReturnResult.success(200,"修改角色成功","edit item :" + roleDTO.getName());
    }

    /**
     *
     *
     * @description:查询角色
     * @param {RoleDTO} roleDTO
     * @return:ReturnResult
     * @author: YuHangChen
     * @time: 29/7/2020 上午11:01
     */
    @RequestMapping("/select")
    public ReturnResult selectbyId(@RequestBody RoleDTO roleDTO) {
        RoleDTO roleDTO1 = roleService.selectById(roleDTO.getId());
        if(roleDTO1 == null){
            return ReturnResult.success(404,"角色不存在",null);
        }else {
            System.out.println(roleDTO1.toString());
            return ReturnResult.success(200,"查询角色信息成功",roleDTO1);
        }
    }

    /**
     *
     *
     * @description:查询角色列表
     * @return:ReturnResult
     * @author: YuHangChen
     * @time: 29/7/2020 上午11:01
     */
    @RequestMapping("/list")
    public ReturnResult list() {
        List<RoleDTO> list = roleService.list();
        if(list == null){
            return ReturnResult.success(404,"列表为空",null);
        }else {
            return ReturnResult.success(200,"查询角色列表成功",list);
        }
    }

    /**
     *
     *
     * @description:为角色添加权限
     * @param {long} rid
     * @param {long} pid
     * @return:ReturnResult
     * @author: YuHangChen
     * @time: 29/7/2020 上午11:01
     */
    @GetMapping("/add_rp")
    public ReturnResult add_permission(@RequestParam(value = "rid",defaultValue = "forezp" , required = false)long rid ,@RequestParam(value = "pid",defaultValue = "forezp" , required = false)long pid ){
        roleService.add_permission(pid ,rid);
        return ReturnResult.success(200,"添加角色成功","add item :" + rid + " , " + pid);
    }

    /**
     *
     *
     * @description:删除角色权限
     * @param {long} rid
     * @param {long} pid
     * @return:ReturnResult
     * @author: YuHangChen
     * @time: 29/7/2020 上午11:01
     */
    @GetMapping("/remove_rp")
    public ReturnResult remove_permission(@RequestParam(value = "rid",defaultValue = "forezp" , required = false)long rid ,@RequestParam(value = "pid",defaultValue = "forezp" , required = false)long pid ){
        roleService.remove_permission(pid,rid);
        return ReturnResult.success(200,"添加角色成功","add item :" + rid + " , " + pid);
    }

    /**
     *
     *
     * @description:查询角色权限
     * @param {RoleDTO} roleDTO
     * @return:ReturnResult
     * @author: YuHangChen
     * @time: 29/7/2020 上午11:01
     */
    @RequestMapping("/selectRP")
    public ReturnResult selectRP_ById(@RequestBody RoleDTO roleDTO) {
        Role_PermissionDTO roleDTO1 = roleService.selectRP_ById(roleDTO.getId());
        if(roleDTO1 == null){
            return ReturnResult.success(404,"角色不存在",null);
        }else {
            return ReturnResult.success(200,"查询角色权限信息成功",roleDTO1);
        }
    }

}
