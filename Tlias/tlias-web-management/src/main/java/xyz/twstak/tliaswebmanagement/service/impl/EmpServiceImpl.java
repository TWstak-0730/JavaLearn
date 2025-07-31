package xyz.twstak.tliaswebmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import xyz.twstak.tliaswebmanagement.mapper.EmpExprMapper;
import xyz.twstak.tliaswebmanagement.mapper.EmpMapper;
import xyz.twstak.tliaswebmanagement.pojo.Emp;
import xyz.twstak.tliaswebmanagement.pojo.EmpExpr;
import xyz.twstak.tliaswebmanagement.pojo.EmpQueryParam;
import xyz.twstak.tliaswebmanagement.pojo.PageResult;
import xyz.twstak.tliaswebmanagement.service.EmpService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Override
    public void addEmp(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.addEmp(emp);
        Integer empId = emp.getId();
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(empExpr -> {
                empExpr.setEmpId(empId);
            });
            empExprMapper.batAddEmpExpr(exprList);
        }
    }

    @Autowired
    EmpMapper empMapper;
    @Autowired
    EmpExprMapper empExprMapper;

    @Override
    public PageResult<Emp> getEmpList(EmpQueryParam empQueryParam) {
//        Integer startIndex = (page-1)*pageSize;
//        Long total = empMapper.getTotal();
//
//        List<Emp> empList = empMapper.getEmpList(startIndex, pageSize);
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        if(empQueryParam.getBegin() == null){
            empQueryParam.setBegin(LocalDate.of(2000,1,1));
        }
        if(empQueryParam.getEnd() == null){
            empQueryParam.setEnd(LocalDate.now());
        }
        Page<Emp> p = (Page<Emp>) empMapper.getEmpList(empQueryParam);
        return new PageResult<Emp>(p.getTotal(),p.getResult());
    }
}
