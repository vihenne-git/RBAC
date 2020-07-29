package com.springcloud.rbac.user_provider.clients;

import com.springcloud.rbac.auth.DTO.RoleDTO;
import com.springcloud.rbac.auth.util.ReturnResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author asus
 * @create 26/7/2020 下午9:15
 */

@FeignClient("role-provider")
public interface UserClient {

    @PostMapping("/role/selectRP")
    ReturnResult selectbyId(@RequestBody RoleDTO roleDTO);

}
