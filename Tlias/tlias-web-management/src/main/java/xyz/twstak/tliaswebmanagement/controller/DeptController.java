package xyz.twstak.tliaswebmanagement.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.twstak.tliaswebmanagement.pojo.Dept;
import xyz.twstak.tliaswebmanagement.pojo.Result;
import xyz.twstak.tliaswebmanagement.service.DeptService;

import java.util.List;

@Slf4j
@RestController
public class DeptController {
    //private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    //@RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping("/depts")
    public Result list() {
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    @DeleteMapping("/depts")
    public Result deleteById(@RequestParam("id") Integer deptId) {

        log.info("删除部门数据，id：" + deptId);
        deptService.deleteById(deptId);
        return Result.success();
    }

    @PostMapping("/depts")
    public Result addDept(@RequestBody Dept dept) {
        log.info("添加部门数据，name：" + dept.getName());
        deptService.addDept(dept);
        return Result.success();
    }

    @PutMapping("/depts")
    public Result updateDept(@RequestBody Dept dept) {
        log.info("修改部门数据，id"+dept.getId()+"name"+dept.getName());
        deptService.updateDept(dept);
        return Result.success();
    }

    @GetMapping("/depts/{id}")
    public Result findById(@PathVariable("id") Integer deptId) {
        log.info("根据ID查询部门数据" + deptId);
        Dept dept = deptService.getInfo(deptId);
        return Result.success(dept);
    }

}
