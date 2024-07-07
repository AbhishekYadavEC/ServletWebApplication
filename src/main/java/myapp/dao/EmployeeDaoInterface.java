package myapp.dao;


import myapp.model.Employee;

import java.util.List;

public interface EmployeeDaoInterface {
    int add(Employee employee);
    int deleteEmployee(int employeeId);
    int updateEmployee(Employee employee);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployee();
}
