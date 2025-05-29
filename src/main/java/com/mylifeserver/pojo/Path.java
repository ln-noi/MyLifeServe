package com.mylifeserver.pojo;

import java.util.Date;
import java.util.List;

public class Path {
    private Long id;
    private String account;
    private String pathName;
    private String createTime;
    private List<PathPoint> points;
    private double totalDistance;
    private String totalTime;
    public Path() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<PathPoint> getPoints() {
        return points;
    }

    public void setPoints(List<PathPoint> points) {
        this.points = points;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }
}

