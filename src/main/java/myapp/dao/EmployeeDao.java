package myapp.dao;





import myapp.controller.DatabaseCon;
import myapp.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao extends DatabaseCon implements EmployeeDaoInterface {

    public int add(Employee employee) {
        int status=0;
        try {
            Connection con = EmployeeDao.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO EMPLOYEE(NAME,PASSWORD,EMAIL,COUNTRY) VALUES(?,?,?,?)");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2,employee.getPassword());
            preparedStatement.setString(3,employee.getEmail());
            preparedStatement.setString(4,employee.getCountry());

            status = preparedStatement.executeUpdate();
            con.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int deleteEmployee(int employeeId) {
        int status=0;
        try{
            Connection connection = EmployeeDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM EMPLOYEE WHERE ID=?");
            preparedStatement.setInt(1,employeeId);
            status = preparedStatement.executeUpdate();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int updateEmployee(Employee employee) {
        int status=0;
        try{
            Connection connection = EmployeeDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE EMPLOYEE SET NAME=?,PASSWORD=?,EMAIL=?,COUNTRY=? WHERE ID=?");
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getPassword());
            preparedStatement.setString(3,employee.getEmail());
            preparedStatement.setString(4,employee.getCountry());

            status = preparedStatement.executeUpdate();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = new Employee();
        try {
            Connection connection = EmployeeDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                employee.setId(resultSet.getInt(1));
                employee.setName(resultSet.getString(2));
                employee.setPassword(resultSet.getString(3));
                employee.setEmail(resultSet.getString(4));
                employee.setCountry(resultSet.getString(5));

            }
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> listOfEmployee = new ArrayList<Employee>();
        try{
            Connection connection = EmployeeDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getInt(1));
                employee.setName(resultSet.getString(2));
                employee.setPassword(resultSet.getString(3));
                employee.setEmail(resultSet.getString(4));
                employee.setCountry(resultSet.getString(5));
                listOfEmployee.add(employee);
            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listOfEmployee;
    }
}
