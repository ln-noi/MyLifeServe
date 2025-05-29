package com.mylifeserver.dao;

import com.mylifeserver.pojo.Path;
import com.mylifeserver.pojo.PathPoint;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PathMapper {

    @Insert("INSERT INTO path(account, path_name,totalDistance,totalTime) VALUES(#{account}, #{pathName},#{totalDistance},#{totalTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertPath(Path path);// 插入路径信息

    @Select("SELECT * FROM path WHERE account = #{account}")
    List<Path> findPathsByAccount(String account);

}
