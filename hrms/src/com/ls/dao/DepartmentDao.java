package com.ls.dao;


import com.ls.model.Department;

import java.util.List;

/**
 * Created by LS on 2017/10/29 10:40.
 * To Be or Not to Be
 */
public interface DepartmentDao {
    boolean addDep(Department department);

    List<Department> queryAllDep();

    boolean deleteDepById(int id);

    void updateDepById(Department department);

    Department queryDepById(int id);

    Department queryDepByDepName(String depName);
}
