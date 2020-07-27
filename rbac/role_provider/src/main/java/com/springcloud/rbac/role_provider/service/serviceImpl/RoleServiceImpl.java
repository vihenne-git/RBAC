package com.springcloud.rbac.role_provider.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.springcloud.rbac.auth.DTO.PermissionDTO;
import com.springcloud.rbac.auth.DTO.RoleDTO;
import com.springcloud.rbac.auth.DTO.Role_PermissionDTO;
import com.springcloud.rbac.auth.PO.Permission;
import com.springcloud.rbac.auth.PO.Role;
import com.springcloud.rbac.auth.PO.Role_permission;
import com.springcloud.rbac.auth.util.ReturnResult;
import com.springcloud.rbac.role_provider.clients.RoleClient;
import com.springcloud.rbac.role_provider.controller.RoleController;
import com.springcloud.rbac.role_provider.dao.RoleDAO;
import com.springcloud.rbac.role_provider.dao.RolePermissionDAO;
import com.springcloud.rbac.role_provider.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author asus
 * @create 26/7/2020 下午2:10
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private RolePermissionDAO rolePermissionDAO;

    @Autowired
    private RoleClient roleClient;

    @Override
    public boolean add(RoleDTO roleDTO) {
        roleDAO.insert(roleDTO.getPO());
        return true;
    }

    @Override
    public boolean remove(long id) {
        roleDAO.deleteById(id);
        return true;
    }

    @Override
    public boolean edit(RoleDTO roleDTO) {
        roleDAO.updateById(roleDTO.getPO());
        return true;
    }

    @Override
    public RoleDTO selectById(long id) {
        Role role = roleDAO.selectById(id);
        if(role==null){
            return null;
        }else {
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.transformToDTO(role);
            return roleDTO;
        }

    }

    @Override
    public List<RoleDTO> list() {
        List<Role> roleList = roleDAO.selectList(null);
        if(roleList == null){
            return null;
        }else {
            List<RoleDTO> roleDTOList = new ArrayList<RoleDTO>();
            for(int i=0;i<roleList.size();i++){
                RoleDTO roleDTO = new RoleDTO();
                roleDTO.transformToDTO(roleList.get(i));
                roleDTOList.add(roleDTO);
            }
            return roleDTOList;
        }
    }

    @Override
    public boolean add_permission(long pid, long rid) {
        Role_permission role_permission = new Role_permission();
        role_permission.setPid(pid);
        role_permission.setRid(rid);
        rolePermissionDAO.insert(role_permission);
        return true;
    }

    @Override
    public boolean remove_permission(long pid,long rid) {
        Map<String, Object> deleteMap = new HashMap<>();
        deleteMap.put("pid", pid);
        deleteMap.put("rid", rid);
        int rows = rolePermissionDAO.deleteByMap(deleteMap);
        return true;
    }

    @Override
    public Role_PermissionDTO selectRP_ById(long id) {
        Role role = roleDAO.selectById(id);
        List<Role_permission> role_permissions = rolePermissionDAO.selectList(new EntityWrapper<Role_permission>().eq("rid",id));
        if(role==null||role_permissions == null){
            return null;
        }else {
            Role_PermissionDTO role_permissionDTO = new Role_PermissionDTO();
            List<PermissionDTO> permissionDTOList =new ArrayList<>();
            for(int i=0;i<role_permissions.size();i++){
                PermissionDTO permissionDTO = new PermissionDTO();
                permissionDTO.setId(role_permissions.get(i).getPid());
                ObjectMapper mapper = new ObjectMapper();
                PermissionDTO permissionDTO1 = mapper.convertValue(roleClient.selectbyId(permissionDTO).getData(), PermissionDTO.class);
                if(permissionDTO1!=null){
                    permissionDTOList.add(permissionDTO1);
                }
            }
            role_permissionDTO.transform(role,permissionDTOList);
            return role_permissionDTO;
        }
    }
}
