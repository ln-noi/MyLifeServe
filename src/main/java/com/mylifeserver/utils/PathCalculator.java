package com.mylifeserver.utils;

import com.mylifeserver.pojo.PathPoint;
import com.mylifeserver.pojo.Result;

import java.util.Comparator;
import java.util.List;

public class PathCalculator {

    private static final double EARTH_RADIUS = 6371.0;

    public static Result calculateTotalLengthAndTime(List<PathPoint> pathPoints) {
        if (pathPoints == null || pathPoints.size() < 2) {
            return new Result(0.0, "00:00:00.000");
        }

        pathPoints.sort(Comparator.comparingLong(PathPoint::getTimestamp));

        long startTime = pathPoints.get(0).getTimestamp();
        long endTime = pathPoints.get(pathPoints.size() - 1).getTimestamp();
        long totalMillis = endTime - startTime;

        System.out.println("Time Difference (milliseconds): " + totalMillis);

        double totalLength = 0.0;
        for (int i = 0; i < pathPoints.size() - 1; i++) {
            PathPoint p1 = pathPoints.get(i);
            PathPoint p2 = pathPoints.get(i + 1);
            totalLength += calculateDistance(p1, p2);
        }

        String formattedTime = formatMilliseconds(totalMillis);

        return new Result(totalLength, formattedTime);
    }

    private static double calculateDistance(PathPoint p1, PathPoint p2) {

        double lat1 = Math.toRadians(p1.getLatitude());
        double lon1 = Math.toRadians(p1.getLongitude());
        double lat2 = Math.toRadians(p2.getLatitude());
        double lon2 = Math.toRadians(p2.getLongitude());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }

    private static String formatMilliseconds(long millis) {
        long totalMillis = millis;

        // 计算小时、分钟、秒和毫秒
        int hours = (int) (totalMillis / 3_600_000);
        int remaining = (int) (totalMillis % 3_600_000);
        int minutes = remaining / 60_000;
        remaining %= 60_000;
        int seconds = remaining / 1_000;
        int milliseconds = remaining % 1_000;
        System.out.println("hours="+hours);
        System.out.println("minutes="+minutes);
        System.out.println("seconds="+seconds);
        // 格式化为 "hh:mm:ss.SSS"
        return String.format("%02d时%02d分%02d秒%03d毫秒", hours, minutes, seconds, milliseconds);
    }
}
