package myapp.controller;

import myapp.dao.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteDetailsEmp")
public class DeleteDetailsEmp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("id");
        int id = Integer.parseInt(sid);
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.deleteEmployee(id);
        resp.sendRedirect("ViewDetails");
    }
}
