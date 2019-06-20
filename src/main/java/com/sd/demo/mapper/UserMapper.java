package com.sd.demo.mapper;

import com.sd.demo.entity.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {

    @Select("SELECT * FROM UserBean WHERE id = #{id}")
    UserBean findOne(int id);

    @Insert("insert into UserBean(name,age,sex) values(#{name},#{age},#{sex})")
    UserBean save(UserBean user);

    @Update("delete from UserBean where id=#{id}")
    UserBean delete(int id);
}