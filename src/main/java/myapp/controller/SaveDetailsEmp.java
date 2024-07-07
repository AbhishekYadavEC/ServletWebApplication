package myapp.controller;

import myapp.dao.EmployeeDao;
import myapp.model.Employee;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class SaveDetailsEmp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String email=req.getParameter("email");
        String country=req.getParameter("country");

        Employee employee = new Employee();
        employee.setName(name);
        employee.setPassword(password);
        employee.setEmail(email);
        employee.setCountry(country);

        EmployeeDao employeeDao = new EmployeeDao();
        int status = employeeDao.add(employee);
        if(status>0){
            out.print("<p>Record add sucessfully!</p>");
            req.getRequestDispatcher("index.html").include(req,resp);
        }
        else {
            out.println("Sorry Unable to save record");
        }
        out.close();
    }
}
