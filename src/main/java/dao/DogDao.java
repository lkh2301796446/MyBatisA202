package dao;

import org.apache.ibatis.annotations.*;
import po.Dog;

import java.util.List;

/**
 * @author lenovo
 * @create 2020-10-01-8:53
 */
public interface DogDao {
    //查询全部
    @Select("select * from dog")
    @Results(id="dogResult",value = {
            @Result(id=true,property="id",column="id"),
            @Result(id=true,property="name",column="name"),
            @Result(id=true,property="love",column="love"),
            @Result(id=true,property="type",column="type"),
    })
    List<Dog> selectAll();
    //根据id查询
    @Select("select * from dog where id=#{id}")
    @ResultMap("dogResult")
    Dog selectById(int id);
    @Delete("delete from dog where id=#{id}")
    int delete(int id);
    @Update("update dog set name=#{name},love=#{love},type=#{type} where id=#{id}")
    int update(Dog id);
    @Insert("insert into dog(name,love,type)values(#{name},#{love},#{type})")
    int insert(Dog dog);

}
