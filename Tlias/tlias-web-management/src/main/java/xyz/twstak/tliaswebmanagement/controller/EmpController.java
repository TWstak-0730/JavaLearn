package xyz.twstak.tliaswebmanagement.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import xyz.twstak.tliaswebmanagement.pojo.Emp;
import xyz.twstak.tliaswebmanagement.pojo.EmpQueryParam;
import xyz.twstak.tliaswebmanagement.pojo.PageResult;
import xyz.twstak.tliaswebmanagement.pojo.Result;
import xyz.twstak.tliaswebmanagement.service.EmpService;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    EmpService empService;
    /**
     * 分页查询*/
    @GetMapping
    public Result getEmps(EmpQueryParam empQueryParam) {

        log.info("分页查询员工列表:{}",empQueryParam);
        PageResult<Emp> pageResult = empService.getEmpList(empQueryParam);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result addEmp(@RequestBody Emp emp) {
        log.info("添加员工:{}", emp);

        empService.addEmp(emp);
        return Result.success();
    }
}
