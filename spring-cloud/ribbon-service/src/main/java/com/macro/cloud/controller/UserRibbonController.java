package com.macro.cloud.controller;

import com.macro.cloud.domain.CommonResult;
import com.macro.cloud.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserRibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.uer-service}")
    private String userServiceUrl;

    @GetMapping("/getAllUers")
    public CommonResult getAllUers() {
        return restTemplate.getForObject(userServiceUrl + "/user/getAllUers", CommonResult.class);
    }

    @GetMapping("/{id}")
    public CommonResult getUser(@PathVariable Integer id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", CommonResult.class, id);
    }

    @RequestMapping("/getByUserName")
    public CommonResult getByUserName(@RequestParam String userName) {
        return restTemplate.getForObject(userServiceUrl + "/user/getByUserName?userName={1}", CommonResult.class, userName);
    }

    @RequestMapping("/getEneityByUserName")
    public CommonResult getEneityByUserName(@RequestParam String userName) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(userServiceUrl + "/user/getByUserName?userName={1}", CommonResult.class, userName);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }

        return new CommonResult(500, "操作失败");
    }

    @RequestMapping("/create")
    public CommonResult create(@RequestBody User user) {
        return restTemplate.postForObject(userServiceUrl + "/user/create", user, CommonResult.class);
    }

    @RequestMapping("/update")
    public CommonResult update(@RequestBody User user) {
        return restTemplate.postForObject(userServiceUrl + "/user/update", user, CommonResult.class);
    }

    @RequestMapping("/delete/{id}")
    public CommonResult delete (@RequestParam Integer id) {
        return restTemplate.postForObject(userServiceUrl + "/user/delete/{1}", null, CommonResult.class, id);
    }



}
