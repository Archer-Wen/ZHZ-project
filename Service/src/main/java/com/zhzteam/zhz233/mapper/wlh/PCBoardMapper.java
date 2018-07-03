package com.zhzteam.zhz233.mapper.wlh;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/23
 */
@Mapper
public interface PCBoardMapper {

    @Select("select * from tab_board where board_name = #{board_name}")
    Map<Object,Object> selectByName(@Param("board_name") String board_name);
}
