package com.mylifeserver.controller;

import com.mylifeserver.pojo.Path;
import com.mylifeserver.pojo.PathPoint;
import com.mylifeserver.pojo.Result;
import com.mylifeserver.pojo.request.TrackUploadRequest;
import com.mylifeserver.service.PathService;
import com.mylifeserver.utils.PathCalculator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mapApi")
@MapperScan("com.mylifeserver.dao")
public class MapController {
    @Autowired
    PathService pathService;
    @PostMapping("/upload")
    public ResponseEntity<String> uploadTrack(@RequestBody TrackUploadRequest request) {
        List<PathPoint> points = request.getPoints();
        Result result = PathCalculator.calculateTotalLengthAndTime(points);

        int flag = pathService.savePathWithPoints(request.getAccount(), request.getPathName(), request.getPoints(),result);
        if(flag==0){
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("上传轨迹失败");
        }
        return ResponseEntity.ok("轨迹上传成功！");
    }

    @GetMapping("/download/account/{account}")
    public ResponseEntity<List<Path>> downloadPaths(@PathVariable String account) {
        List<Path> result = pathService.getFullPaths(account);
        for(Path path:result){
            System.out.println(path.getId());
        }
        if (result.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }
}