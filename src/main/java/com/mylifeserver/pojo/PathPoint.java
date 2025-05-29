package com.mylifeserver.pojo;

public class PathPoint {
        private Long id;
        private Long pathId;
        private Double latitude;
        private Double longitude;
        private Long timestamp;

    public PathPoint() {
    }

    public PathPoint(Long id, Long pathId, Double latitude, Double longitude, Long timestamp) {
        this.id = id;
        this.pathId = pathId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPathId() {
        return pathId;
    }

    public void setPathId(Long pathId) {
        this.pathId = pathId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}

