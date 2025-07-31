package xyz.twstak.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import xyz.twstak.tliaswebmanagement.pojo.EmpExpr;

import java.util.List;

/**
 * 员工工作经历
 */
@Mapper
public interface EmpExprMapper {


    void batAddEmpExpr(List<EmpExpr> exprList);
}
