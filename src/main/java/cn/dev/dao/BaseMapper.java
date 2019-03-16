package cn.dev.dao;

import cn.dev.model.Base;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BaseMapper {

    List<Base> filter(@Param("base") Base base, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select * from base where id =#{id}")
    Base findById(@Param("id") Integer id);

    @Select("select * from base where name =#{name}")
    Base findByName(@Param("name") String name);


    @Insert("insert into base(name,createtime,remarks) values( #{name},now(),#{remarks})")
    Integer add(Base base);


    Integer updateById(Base base);

    @Update("update base set name=#{name},remarks=#{remarks} where  id=#{id}")
    Integer replaceById(Base base);

    //如果指定为 true，则方法调用后将立即清空所有缓存
    @Update("update base set del_tag='1' where id=#{id}")
    Integer deleteById(@Param("id") Integer id);
}
