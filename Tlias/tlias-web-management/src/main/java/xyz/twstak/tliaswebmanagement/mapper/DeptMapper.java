package xyz.twstak.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.*;
import xyz.twstak.tliaswebmanagement.pojo.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {

    /**
     * 获取部门列表
     * @return 部门列表
     */
//    @Results({
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//    })
    @Select("select id, name, create_time, update_time from dept order by update_time desc")
    List<Dept> findAll();

    /**
     * 删除部门
     * @param id 部门ID
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    @Insert("INSERT INTO dept(name, create_time, update_time) value (#{name},#{createTime},#{updateTime})")
    void addDept(Dept dept);

    @Update("UPDATE dept SET name = #{name},update_time = #{updateTime} where id = #{id}")
    void updateDept(Dept dept);

    @Select("SELECT id, name, create_time, update_time from dept where id = #{id}")
    Dept getInfoById(Integer deptId);
}
