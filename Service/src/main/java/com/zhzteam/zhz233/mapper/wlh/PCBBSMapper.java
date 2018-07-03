package com.zhzteam.zhz233.mapper.wlh;

import com.zhzteam.zhz233.model.BBSModel;
import com.zhzteam.zhz233.model.ReplyModel;
import com.zhzteam.zhz233.model.wlh.ShowBBSView;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/23
 */
@Mapper
public interface PCBBSMapper {

    //显示在BBS首页的数据
    @Select("SELECT tb.bbs_id,tb.bbs_title,tu.account,tb.createtime,tbd.board_name,tb.bbs_count from tab_bbs tb\n" +
            "left join tab_user tu on tb.account_no = tu.account_no\n" +
            "left JOIN tab_board tbd on tb.board_id = tbd.id\n" +
            "where tb.board_id = #{board_id} ORDER BY tb.updatetime desc")
    List<ShowBBSView> ShowBBS(@Param("board_id") Integer board_id);

    @Select("SELECT tb.bbs_id,tb.bbs_title,tu.account,tb.createtime,tbd.board_name,tb.bbs_count from tab_bbs tb\n" +
            "left join tab_user tu on tb.account_no = tu.account_no\n" +
            "left JOIN tab_board tbd on tb.board_id = tbd.id\n" +
            "where tb.bbs_id = #{bbs_id}")
    ShowBBSView ShowOneBBS(@Param("bbs_id")Integer bbs_id);

    //删除一条记录
    @Delete("delete from tab_bbs WHERE bbs_id = #{bbsId}")
    Integer deleteBBS(@Param("bbsId")Integer bbsId);

    @Select("select * from tab_bbs where bbs_id = #{bbsId}")
    BBSModel findOne(@Param("bbsId")Integer bbsId);

    @Insert("<script>insert into tab_bbs ("+
            "<if test='bbs_id!=null'>bbs_id,</if>"+
            "account_no,bbs_title,bbs_count,board_id,createtime" +
            ",updatetime" +
            ") "+
            "VALUES ("+
            "<if test='bbs_id!=null'>#{bbs_id},</if>"+
            "#{account_no},#{bbs_title},#{bbs_count},#{board_id},#{createtime}" +
            ",#{updatetime}" +
            ")</script>")
    @Options(useGeneratedKeys = true,keyProperty = "bbs_id")
    Integer insertOne(BBSModel bbsPojo);
}
