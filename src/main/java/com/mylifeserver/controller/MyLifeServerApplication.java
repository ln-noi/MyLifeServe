package com.mylifeserver.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
@RestController
@RequestMapping("/api")
@ComponentScan("com.mylifeserver")
public class MyLifeServerApplication {

    private static final ConcurrentHashMap<String, Long> connectedDevices = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(MyLifeServerApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        // 获取客户端IP地址
        String clientIp = request.getRemoteAddr();
        // 更新设备的最新访问时间
        connectedDevices.put(clientIp, System.currentTimeMillis());

        return  clientIp ;
    }
}
