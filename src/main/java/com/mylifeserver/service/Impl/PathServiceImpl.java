package com.mylifeserver.service.Impl;

import com.mylifeserver.dao.PathMapper;
import com.mylifeserver.dao.PathPointMapper;
import com.mylifeserver.pojo.Path;
import com.mylifeserver.pojo.PathPoint;
import com.mylifeserver.pojo.Result;
import com.mylifeserver.pojo.request.TrackUploadRequest;
import com.mylifeserver.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PathServiceImpl implements PathService {
    @Autowired
    PathMapper pathMapper;
    @Autowired
    PathPointMapper pathPointMapper;
    @Override
    public int savePathWithPoints(String account, String pathName, List<PathPoint> points, Result result) {
        // 1. 插入路径信息
        Path path = new Path();
        path.setAccount(account);
        path.setPathName(pathName);
        path.setTotalDistance(result.getTotalDistance());
        path.setTotalTime(result.getTotalTime());
        int pathAccord = pathMapper.insertPath(path);

        // 2. 插入所有点
        Long pathId = path.getId();
        for (PathPoint p : points) {
            p.setPathId(pathId);
        }
        int pathPointAccord = pathPointMapper.insertPoints(points);
        return pathPointAccord*pathAccord;
    }

    @Override
    public List<Path> getFullPaths(String account) {
        List<Path> pathList = pathMapper.findPathsByAccount(account);

        for (Path path : pathList) {
            path.setPoints(pathPointMapper.findPathPointsByPathId(path.getId()));
        }

        return pathList;
    }
}
