package myapp.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import myapp.dao.EmployeeDao;
import myapp.model.Employee;

@WebServlet("/ViewDetails")
public class ViewDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<a href='index.html'>Add New Employee</a>");
        out.println("<h1>Employees List</h1>");



        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> list= employeeDao.getAllEmployee();
        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
        for(Employee e:list){
            out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td><td><a href='EditDetailsEmp?id="+e.getId()+"'>edit</a></td> <td><a href='DeleteDetailsEmp?id="+e.getId()+"'>delete</a></td></tr>");
        }
        out.print("</table>");

        out.close();
    }
}
