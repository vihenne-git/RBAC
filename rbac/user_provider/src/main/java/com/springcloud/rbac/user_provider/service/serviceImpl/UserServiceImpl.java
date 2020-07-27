package com.springcloud.rbac.user_provider.service.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcloud.rbac.auth.DTO.*;
import com.springcloud.rbac.auth.PO.User;
import com.springcloud.rbac.auth.PO.User_role;
import com.springcloud.rbac.user_provider.clients.UserClient;
import com.springcloud.rbac.user_provider.dao.UserDAO;
import com.springcloud.rbac.user_provider.dao.User_roleDAO;
import com.springcloud.rbac.user_provider.service.UserService;
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
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private User_roleDAO user_roleDAO;
    @Autowired
    private UserClient userClient;

    @Override
    public boolean add(UserDTO userDTO) {
        userDAO.insert(userDTO.getPO());
        return true;
    }

    @Override
    public boolean remove(long id) {
        userDAO.deleteById(id);
        return true;
    }

    @Override
    public boolean edit(UserDTO userDTO) {
        userDAO.updateById(userDTO.getPO());
        return true;
    }

    @Override
    public UserDTO selectById(long id) {
        User user = userDAO.selectById(id);
        if(user==null){
            return null;
        }else {
            UserDTO userDTO = new UserDTO();
            userDTO.transformToDTO(user);
            return userDTO;
        }
    }

    @Override
    public List<UserDTO> list() {
        List<User> userList = userDAO.selectList(null);
        if(userList == null){
            return null;
        }else {
            List<UserDTO> userDTOList = new ArrayList<UserDTO>();
            for(int i=0;i<userList.size();i++){
                UserDTO userDTO = new UserDTO();
                userDTO.transformToDTO(userList.get(i));
                userDTOList.add(userDTO);
            }
            return userDTOList;
        }
    }

    @Override
    public boolean add_role(long uid, long rid) {
        User_role user_role = new User_role();
        user_role.setUid(uid);
        user_role.setRid(rid);
        user_roleDAO.insert(user_role);
        return true;
    }

    @Override
    public boolean remove_role(long uid, long rid) {
        Map<String, Object> deleteMap = new HashMap<>();
        deleteMap.put("uid", uid);
        deleteMap.put("rid", rid);
        int rows = user_roleDAO.deleteByMap(deleteMap);
        return true;
    }

    @Override
    public User_Role_PermissionDTO selectURP_ById(long id) {
        User user = userDAO.selectById(id);
        List<User_role> user_roles = user_roleDAO.selectList(new EntityWrapper<User_role>().eq("uid",id));
        if(user==null||user_roles == null){
            return null;
        }else {
            User_Role_PermissionDTO user_role_permissionDTO = new User_Role_PermissionDTO();
            List<Role_PermissionDTO> role_permissionDTOS = new ArrayList<>();
            for(int i=0;i<user_roles.size();i++){
                RoleDTO roleDTO = new RoleDTO();
                roleDTO.setId(user_roles.get(i).getRid());
                ObjectMapper mapper = new ObjectMapper();
                Role_PermissionDTO role_permissionDTO = mapper.convertValue(userClient.selectbyId(roleDTO).getData(), Role_PermissionDTO.class);
                if(role_permissionDTO!=null){
                    role_permissionDTOS.add(role_permissionDTO);
                }
            }
            user_role_permissionDTO.transform(user,role_permissionDTOS);
            return user_role_permissionDTO;
        }
    }
}
