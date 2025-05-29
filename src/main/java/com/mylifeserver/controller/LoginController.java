package com.mylifeserver.controller;

import com.mylifeserver.pojo.request.LoginRequest;
import com.mylifeserver.pojo.User;
import com.mylifeserver.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/loginApi")
@MapperScan("com.mylifeserver.dao")
public class LoginController {
    @Autowired
    UserService userService;

    StringBuilder verificationCode;

    @PostMapping("/login")
    public ResponseEntity<?> getLogin(@RequestBody LoginRequest loginRequest) {
        User user = userService.findUserByAccount(loginRequest.getAccount());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("账号不存在");
        }
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("密码错误");
        }
        if (user.getAvailable() != 1) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("账号不可用");
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/registe")
    public ResponseEntity<?> Registe(@RequestBody User user) {
        List<String> allAccount = userService.findAllAccount();

        if (allAccount.contains(user.getAccount())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("账号已存在");
        }
        int flag = userService.createUser(user);
        if (flag == 1) {
            return ResponseEntity.ok("注册成功");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("注册失败");
        }
    }

    @GetMapping("/getVerificationCode")
    public ResponseEntity<?> getVerificationCode() {
        verificationCode= new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int digit = random.nextInt(10);
            verificationCode.append(digit);
        }
        return ResponseEntity.ok(verificationCode.toString());
    }
    @PostMapping("/changeName")
    public ResponseEntity<?> changeName(@RequestBody LoginRequest loginRequest) {

        int flag = userService.changeName(loginRequest.getAccount(),loginRequest.getName());
        if(flag==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("昵称修改失败");
        }
        return ResponseEntity.ok("修改成功");
    }


    @PostMapping("/changePassword")
    public ResponseEntity<?> changePassword(@RequestBody LoginRequest loginRequest) {
        if(!loginRequest.getVerificationCode().equals(verificationCode.toString())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("验证码错误");
        }
        int flag = userService.changePassword(loginRequest.getAccount(),loginRequest.getPassword());
        if(flag==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("密码修改失败");
        }
        return ResponseEntity.ok("修改成功");
    }

    @PostMapping("/changeImage")
    public ResponseEntity<?> changeImage(@RequestParam("image") MultipartFile file,
                                         @RequestParam("account") String account) {
        // 检查文件是否为空
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("没有上传文件");
        }

        try {
            String uploadDirectory = "D:\\ZL\\MyLifeServe\\images";
            Path path = Paths.get(uploadDirectory, file.getOriginalFilename());
            if (Files.exists(path)) {
                Files.delete(path);
            }
            Files.copy(file.getInputStream(), path);

            userService.changeImage(path.toString(),account);

            return ResponseEntity.ok("文件上传成功: " + path.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("文件上传失败");
        }
    }


    @GetMapping("/getImage/{account}")
    public ResponseEntity<Resource> getImage(@PathVariable String account) {
        try {
            String imageName = "image" + account + ".jpg";
            Path path = Paths.get("D:/ZL/MyLifeServe/images", imageName);

            if (Files.exists(path)) {
                Resource resource = new FileSystemResource(path);
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(resource);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
