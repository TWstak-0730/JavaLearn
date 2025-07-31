package xyz.twstak.tliaswebmanagement.service;

import org.springframework.stereotype.Service;
import xyz.twstak.tliaswebmanagement.pojo.Emp;
import xyz.twstak.tliaswebmanagement.pojo.EmpQueryParam;
import xyz.twstak.tliaswebmanagement.pojo.PageResult;

import java.time.LocalDate;

@Service
public interface EmpService {
    PageResult<Emp> getEmpList(EmpQueryParam empQueryParam);

    void addEmp(Emp emp);
}
