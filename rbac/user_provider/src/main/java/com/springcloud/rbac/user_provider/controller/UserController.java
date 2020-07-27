package com.springcloud.rbac.user_provider.controller;

import com.springcloud.rbac.auth.DTO.RoleDTO;
import com.springcloud.rbac.auth.DTO.Role_PermissionDTO;
import com.springcloud.rbac.auth.DTO.UserDTO;
import com.springcloud.rbac.auth.DTO.User_Role_PermissionDTO;
import com.springcloud.rbac.auth.PO.User;
import com.springcloud.rbac.auth.util.ReturnResult;
import com.springcloud.rbac.user_provider.service.UserService;
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
@RequestMapping("/user")
public class UserController  {
    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public ReturnResult add(@RequestBody UserDTO userDTO) {
        userService.add(userDTO);
        return ReturnResult.success(200,"添加用户成功","add item :" + userDTO.getNickname());
    }
    @RequestMapping("/remove")
    public ReturnResult remove(@RequestBody UserDTO userDTO) {
        userService.remove(userDTO.getId());
        return ReturnResult.success(200,"删除用户成功","remove item :" + userDTO.getNickname());
    }

    @RequestMapping("/edit")
    public ReturnResult edit(@RequestBody UserDTO userDTO) {
        userService.edit(userDTO);
        return ReturnResult.success(200,"修改用户信息成功","edit item :" + userDTO.getNickname());
    }

    @RequestMapping("/select")
    public ReturnResult selectbyId(@RequestBody UserDTO userDTO) {
        UserDTO userDTO1 = userService.selectById(userDTO.getId());
        if(userDTO1 == null){
            return ReturnResult.success(404,"用户不存在",null);
        }else {
            return ReturnResult.success(200,"查询用户信息成功",userDTO1);
        }
    }

    @RequestMapping("/list")
    public ReturnResult list() {
        List<UserDTO> list = userService.list();
        if(list == null){
            return ReturnResult.success(404,"列表为空",null);
        }else {
            return ReturnResult.success(200,"查询用户列表成功",list);
        }
    }


    @GetMapping("/add_ur")
    public ReturnResult add_role(@RequestParam(value = "rid",defaultValue = "forezp" , required = false)long rid , @RequestParam(value = "pid",defaultValue = "forezp" , required = false)long uid ){
        userService.add_role(uid,rid);
        return ReturnResult.success(200,"添加用户角色成功","add item :" + rid + " , " + uid);
    }

    @GetMapping("/remove_ur")
    public ReturnResult remove_role(@RequestParam(value = "rid",defaultValue = "forezp" , required = false)long rid ,@RequestParam(value = "pid",defaultValue = "forezp" , required = false)long uid ){
        userService.remove_role(uid,rid);
        return ReturnResult.success(200,"删除用户角色成功","add item :" + rid + " , " + uid);
    }

    @RequestMapping("/selectURP")
    public ReturnResult selectURP_ById(@RequestBody UserDTO userDTO) {
        User_Role_PermissionDTO user_role_permissionDTO = userService.selectURP_ById(userDTO.getId());
        if(user_role_permissionDTO == null){
            return ReturnResult.success(404,"角色不存在",null);
        }else {
            return ReturnResult.success(200,"查询角色权限信息成功",user_role_permissionDTO);
        }
    }

}
