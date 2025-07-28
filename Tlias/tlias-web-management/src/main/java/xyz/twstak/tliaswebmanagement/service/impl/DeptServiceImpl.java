package xyz.twstak.tliaswebmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.twstak.tliaswebmanagement.mapper.DeptMapper;
import xyz.twstak.tliaswebmanagement.pojo.Dept;
import xyz.twstak.tliaswebmanagement.service.DeptService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {


    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> findAll() {

        return deptMapper.findAll();
    }


    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void addDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.addDept(dept);
    }

    @Override
    public void updateDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateDept(dept);
    }
    @Override
    public Dept getInfo(Integer deptId) {
        return deptMapper.getInfoById(deptId);
    }
}
