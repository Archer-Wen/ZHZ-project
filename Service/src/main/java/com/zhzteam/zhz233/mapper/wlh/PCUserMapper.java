package com.zhzteam.zhz233.mapper.wlh;

import com.zhzteam.zhz233.model.UserModel;
import org.apache.ibatis.annotations.*;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/22
 */
@Mapper
public interface PCUserMapper {
    //根据用户名查询一个实体
    @Select("select * from tab_user where account = #{username}")
    UserModel selectByAccount(String username);

    @Insert("insert into tab_user(account_no,account,cell_phone,password,update_time,create_time,access) values "
            +"(#{account_no},#{account},#{cell_phone},#{password},#{update_time},#{create_time},#{access})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert(UserModel pojo);

    @Update("update tab_user set account_no=#{account_no},account=#{account},cell_phone=#{cell_phone},password=#{password},update_time=#{update_time},create_time=#{create_time},access=#{access}")
    int update(UserModel user);
}
