package myapp.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import myapp.dao.EmployeeDao;
import myapp.model.Employee;



@WebServlet("/EditDetailsEmp1")
public class EditDetailsEmp1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();

        String sid=req.getParameter("id");
        int id=Integer.parseInt(sid);
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String email=req.getParameter("email");
        String country=req.getParameter("country");

       Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setPassword(password);
        employee.setEmail(email);
        employee.setCountry(country);

        EmployeeDao employeeDao= new EmployeeDao();
        int status=employeeDao.updateEmployee(employee);
        if(status>0){
            resp.sendRedirect("ViewDetails");
        }else{
            out.println("Sorry! unable to update record");
        }

        out.close();
    }
}
