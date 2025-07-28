package xyz.twstak.tliaswebmanagement.service;


import xyz.twstak.tliaswebmanagement.pojo.Dept;

import java.util.List;

public interface DeptService {

    /**
     * 获取部门列表
     * @return 部门列表
     */
    List<Dept> findAll();

    /**
     * 删除部门
     * @param id 部门ID
     */
    void deleteById(Integer id);

    /**
     * 新增部门
     * @param dept 部门name
     */
    void addDept(Dept dept);

    /**
     * 新增部门
     * @param dept 部门id与修改后的name
     */
    void updateDept(Dept dept);

    Dept getInfo(Integer deptId);
}
