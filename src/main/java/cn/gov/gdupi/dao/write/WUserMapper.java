package cn.gov.gdupi.dao.write;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * 　　@Cacheable将查询结果缓存到redis中，（key="#p0"）指定传入的第一个参数作为redis的key。
 * <p>
 * 　　@CachePut，指定key，将更新的结果同步到redis中
 * <p>
 * 　　@CacheEvict，指定key，删除缓存数据，allEntries=true,方法调用后将立即清除缓存
 */

public interface WUserMapper {
    @Insert("insert into user(name,create_time,remarks,password) values( #{name},now(),remarks, #{password} )")
    int addUser(@Param("name") String name, @Param("password") String password, @Param("remarks") String remarks);

    @Cacheable(key = "id", value = "user")
    @Update("update user set name=#{name},password=${password},role=#{role} where  id=#{id}")
    int updateById(@Param("id") String id, @Param("name") String name, @Param("password") String password, @Param("role") String role);

    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key = "#p0", allEntries = true)
    @Update("update user set del_tag='1' where id=#{id}")
    int deleteById(@Param("id") String id);

}