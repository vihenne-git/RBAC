package com.springcloud.rbac.permission_provider.service.serviceImpl;

import com.springcloud.rbac.auth.DTO.PermissionDTO;
import com.springcloud.rbac.auth.PO.Permission;
import com.springcloud.rbac.permission_provider.dao.PermissionDAO;
import com.springcloud.rbac.permission_provider.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author asus
 * @create 26/7/2020 下午2:10
 */
@Service
@Slf4j
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDAO permissionDAO;

    @Override
    public boolean add(PermissionDTO permissionDTO) {
        permissionDAO.insert(permissionDTO.getPO());
        return true;
    }

    @Override
    public boolean remove(long id) {
        permissionDAO.deleteById(id);
        return true;
    }

    @Override
    public boolean edit(PermissionDTO permissionDTO) {
        permissionDAO.updateById(permissionDTO.getPO());
        return true;
    }

    @Override
    public PermissionDTO selectById(long id) {
        Permission permission = permissionDAO.selectById(id);
        if(permission==null){
            return null;
        }else {
            PermissionDTO permissionDTO = new PermissionDTO();
            permissionDTO.transformToDTO(permission);

            return permissionDTO;
        }

    }

    @Override
    public List<PermissionDTO> list() {
        List<Permission> permissionList = permissionDAO.selectList(null);
        if(permissionList == null){
            return null;
        }else {
            List<PermissionDTO> permissionDTOList = new ArrayList<PermissionDTO>();
            for(int i=0;i<permissionList.size();i++){
                PermissionDTO permissionDTO = new PermissionDTO();
                permissionDTO.transformToDTO(permissionList.get(i));
                permissionDTOList.add(permissionDTO);
            }
            return permissionDTOList;
        }
    }


}
