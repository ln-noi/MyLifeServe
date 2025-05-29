package com.mylifeserver.utils;

import com.mylifeserver.pojo.PathPoint;

import java.util.List;
import java.util.Map;

public class PathPointSqlProvider {

    /**
     * 构造批量插入轨迹点的 SQL
     */
    public String insertPoints(Map<String, Object> params) {
        List<PathPoint> points = (List<PathPoint>) params.get("points");

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO path_point(path_id, latitude, longitude, timestamp) VALUES ");

        for (int i = 0; i < points.size(); i++) {
            sb.append("(#{points[").append(i).append("].pathId}, ")
                    .append("#{points[").append(i).append("].latitude}, ")
                    .append("#{points[").append(i).append("].longitude}, ")
                    .append("#{points[").append(i).append("].timestamp})");

            if (i < points.size() - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}

