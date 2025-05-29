package com.mylifeserver.service;

import com.mylifeserver.pojo.Path;
import com.mylifeserver.pojo.PathPoint;
import com.mylifeserver.pojo.Result;
import com.mylifeserver.pojo.User;
import com.mylifeserver.pojo.request.TrackUploadRequest;

import java.util.List;

public interface PathService {
    int savePathWithPoints(String account, String pathName, List<PathPoint> points, Result result);
    List<Path> getFullPaths(String account);
}
