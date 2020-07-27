package com.springcloud.rbac.permission_provider.controller;

import com.springcloud.rbac.auth.DTO.PermissionDTO;
import com.springcloud.rbac.auth.util.ReturnResult;
import com.springcloud.rbac.permission_provider.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author asus
 * @create 26/7/2020 下午1:59
 */
@Slf4j
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/add")
    public ReturnResult add(@RequestBody PermissionDTO permissionDTO) {
        permissionService.add(permissionDTO);
        return ReturnResult.success(200,"添加权限成功","add item :" + permissionDTO.getName());
    }
    @RequestMapping("/remove")
    public ReturnResult remove(@RequestBody PermissionDTO permissionDTO) {
        permissionService.remove(permissionDTO.getId());
        return ReturnResult.success(200,"删除权限成功","remove item :" + permissionDTO.getName());
    }

    @RequestMapping("/edit")
    public ReturnResult edit(@RequestBody PermissionDTO permissionDTO) {
        permissionService.edit(permissionDTO);
        return ReturnResult.success(200,"修改权限成功","edit item :" + permissionDTO.getName());
    }

    @RequestMapping("/select")
    public ReturnResult selectbyId(@RequestBody PermissionDTO permissionDTO) {
        PermissionDTO permissionDTO1 = permissionService.selectById(permissionDTO.getId());
        if(permissionDTO1 == null){
            return ReturnResult.success(404,"权限不存在",null);
        }else {
            return ReturnResult.success(200,"查询权限信息成功",permissionDTO1);
        }
    }

    @RequestMapping("/list")
    public ReturnResult list() {
        List<PermissionDTO> list = permissionService.list();
        if(list == null){
            return ReturnResult.success(404,"列表为空",null);
        }else {
            return ReturnResult.success(200,"查询权限列表成功",list);
        }
    }

}
