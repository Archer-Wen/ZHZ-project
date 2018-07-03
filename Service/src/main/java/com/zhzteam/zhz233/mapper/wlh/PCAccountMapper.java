package com.zhzteam.zhz233.mapper.wlh;

import com.zhzteam.zhz233.model.AccountModel;
import org.apache.ibatis.annotations.*;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/24
 */
@Mapper
public interface PCAccountMapper {
    @Select("select * from tab_account")
    AccountModel selectAll();

    @Update("update tab_account set account_no=#{account_no},certification=#{certification},available=#{available},frozen=#{frozen},credit_level=#{credit_level},"
            +"traders_password=#{traders_password},traders_alipay=#{traders_alipay},traders_wechat_pay=#{traders_wechat_pay},update_time=#{update_time}")
    int update(AccountModel pojo);

    @Delete("delete from tab_account where id=#{id}")
    public int delete(int id);

    @Insert("insert into tab_account(account_no,certification,available,frozen,credit_level,traders_password,traders_alipay,traders_wechat_pay,update_time,create_time) values"
            +"(#{account_no},#{certification},#{available},#{frozen},#{credit_level},#{traders_password},#{traders_alipay},#{traders_wechat_pay},#{update_time},#{create_time})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert(AccountModel pojo);
}
