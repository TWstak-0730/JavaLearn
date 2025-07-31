package xyz.twstak.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import xyz.twstak.tliaswebmanagement.pojo.Emp;
import xyz.twstak.tliaswebmanagement.pojo.EmpQueryParam;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工信息
 * */
@Mapper
public interface EmpMapper {
//    /**
//     * 查询符合条件的总记录数*/
//    @Select("SELECT count(*) from emp e left join dept d on e.dept_id = d.id")
//    public Long getTotal();
//
//    /**
//     * 分页查询
//     * */
//    @Select("SELECT e.*,d.name dept_name from emp e left join dept d on e.dept_id = d.id order by e.update_time desc LIMIT #{pageSize} offset #{startIndex}")
//    public List<Emp> getEmpList(Integer startIndex, Integer pageSize);

    //@Select()
    List<Emp> getEmpList(EmpQueryParam empQueryParam);

    /**
     * 添加员工
     * */
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("INSERT INTO emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) values (#{username},#{name}, #{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    Integer addEmp(Emp emp);
}
