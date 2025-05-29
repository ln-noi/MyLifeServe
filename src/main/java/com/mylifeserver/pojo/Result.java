package com.mylifeserver.pojo;

public class Result {
    private double totalDistance;
    private String totalTime;

    public Result(double totalDistance, String totalTime) {
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
    }

    public Result() {
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
