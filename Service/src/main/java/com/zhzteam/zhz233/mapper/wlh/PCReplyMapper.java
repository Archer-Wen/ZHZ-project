package com.zhzteam.zhz233.mapper.wlh;

import com.zhzteam.zhz233.model.ReplyModel;
import com.zhzteam.zhz233.model.wlh.ShowReplyView;
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
public interface PCReplyMapper {

    @Delete("delete from tab_reply where tab_reply.bbs_id = #{bbsId}")
    Integer deleteReplyByBBSId(@Param("bbsId") Integer bbsId);

    @Select("select count(bbs_id) from tab_reply where tab_reply.bbs_id = #{bbsId}")
    Integer CountByBBSId(@Param("bbsId")Integer bbsId);

    @Select("select tr.id,tr.reply_count,tu.account,tr.create_time from tab_reply tr\n" +
            "left join tab_user tu on tr.account_no = tu.account_no\n" +
            "where tr.bbs_id = #{bbs_id} ORDER BY tr.create_time desc")
    List<ShowReplyView> ShowReply(@Param("bbs_id")Integer bbs_id);

    @Insert("INSERT into tab_reply(reply_count,account_no,bbs_id,create_time) " +
            "VALUES (#{reply_count},#{account_no},#{bbs_id},#{create_time})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Integer insertReply(ReplyModel replyModel);
}
