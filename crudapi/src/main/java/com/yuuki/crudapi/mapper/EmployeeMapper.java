package com.yuuki.crudapi.mapper;

import com.yuuki.crudapi.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface EmployeeMapper {
    // MyBatis の Select アノテーションを使って、全ての従業員を取得するSQLクエリを定義
    @Select("SELECT * FROM employees")
    List<Employee> findAll();

    // 特定のIDの従業員を取得するSQLクエリを定義
    @Select("SELECT * FROM employees WHERE id = #{id}")
    Optional<Employee> findById(int id);

    // 特定の部署の従業員を取得するSQLクエリを定義
    @Select("SELECT * FROM employees WHERE department = #{department}")
    List<Employee> findByDepartment(String department);
}
