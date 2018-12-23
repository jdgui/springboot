package com.jundagui.mapper;

import com.jundagui.entity.User;
import com.jundagui.support.SexHandler;
import com.jundagui.support.StateHandler;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM `hs_user` WHERE `state_code` = 0 LIMIT #{offset}, #{limit}")
    @Results(value = {
            @Result(property = "userId", column = "user_id", javaType = Long.class),
            @Result(property = "sex", column = "sex_code", typeHandler = SexHandler.class),
            @Result(property = "state", column = "state_code", typeHandler = StateHandler.class),
            @Result(property = "createTime", column = "create_time", javaType = Date.class),
            @Result(property = "updateTime", column = "update_time", javaType = Date.class)
    })
    List<User> query(@Param("offset") int offset, @Param("limit") int limit);

    @Select("SELECT * FROM `hs_user` WHERE `user_id`= #{userId}")
    @Results(value = {
            @Result(property = "userId", column = "user_id", javaType = Long.class),
            @Result(property = "sex", column = "sex_code", typeHandler = SexHandler.class),
            @Result(property = "state", column = "state_code", typeHandler = StateHandler.class),
            @Result(property = "createTime", column = "create_time", javaType = Date.class),
            @Result(property = "updateTime", column = "update_time", javaType = Date.class)
    })
    User queryByUserId(Long userId);

    @Select("SELECT count(*) AS count FROM `hs_user`")
    Integer totalCount();

    @Insert("INSERT INTO `hs_user`(`user_id`,`name`,`sex_code`,`age`) VALUES (#{userId},#{name},#{sex.code},#{age})")
    int insert(User user);

    @Update("UPDATE `hs_user` SET `name`= #{name},`age`= #{age},`sex_code`= #{sex.code} WHERE `user_id`= #{userId}")
    int update(User user);

    @Delete("UPDATE `hs_user` SET `state_code`=1 WHERE `user_id`= #{userId}")
    int logicalDelete(Long userId);
}
