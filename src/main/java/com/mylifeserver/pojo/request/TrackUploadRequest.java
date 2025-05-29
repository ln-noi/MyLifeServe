package com.mylifeserver.pojo.request;

import com.mylifeserver.pojo.PathPoint;

import java.util.List;

public class TrackUploadRequest {
    private String account;
    private String pathName;
    private List<PathPoint> points;

    public TrackUploadRequest() {
    }

    public TrackUploadRequest(String account, String pathName, List<PathPoint> points) {
        this.account = account;
        this.pathName = pathName;
        this.points = points;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public List<PathPoint> getPoints() {
        return points;
    }

    public void setPoints(List<PathPoint> points) {
        this.points = points;
    }
}

