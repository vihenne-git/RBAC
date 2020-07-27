package com.springcloud.rbac.role_provider.clients;

/**
 * @Author asus
 * @create 26/7/2020 下午9:15
 */

import com.springcloud.rbac.auth.DTO.PermissionDTO;
import com.springcloud.rbac.auth.util.ReturnResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("permission-provider")
public interface RoleClient {
    @PostMapping("/permission/select")
    ReturnResult selectbyId(@RequestBody PermissionDTO permissionDTO);
}
