package com.springcloud.rbac.permission_provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author asus
 * @create 23/7/2020 下午4:32
 */
@RestController
public class ProviderController {
   // Logger logger = LoggerFactory.getLogger(ProviderController.class);
    @GetMapping("/hi")
    public String hi(@RequestParam(value = "name",defaultValue = "forezp" , required = false)String name){
        return "hi " + name;
    }
    @PostMapping("/hello")
    public String Hello(@RequestParam(value = "name",defaultValue = "forezp" , required = false)String name){
        return "Hello " + name;
    }


}
