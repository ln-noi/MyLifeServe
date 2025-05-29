package com.mylifeserver.dao;

import com.mylifeserver.pojo.PathPoint;
import com.mylifeserver.utils.PathPointSqlProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PathPointMapper {
    @InsertProvider(type = PathPointSqlProvider.class, method = "insertPoints")
    int insertPoints(@Param("points") List<PathPoint> points);

    @Select("SELECT * FROM path_point WHERE path_id = #{pathId}")
    List<PathPoint> findPathPointsByPathId(Long pathId);
}
