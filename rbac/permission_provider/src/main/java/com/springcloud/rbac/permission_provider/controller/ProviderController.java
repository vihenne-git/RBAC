package com.springcloud.rbac.permission_provider.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Author asus
 * @create 23/7/2020 下午4:32
 */
@CrossOrigin
@RestController
public class ProviderController {

    @GetMapping("/hi")
    public String hi(){
        return "hi vihenne";
    }

    @PostMapping("/hello")
    public String Hello(@RequestParam(value = "name",defaultValue = "forezp" , required = false)String name){
        return "Hello " + name;
    }


}
