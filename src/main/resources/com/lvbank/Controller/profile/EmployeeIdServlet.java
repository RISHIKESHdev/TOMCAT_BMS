package com.lvbank.Controller.profile;

import com.lvbank.Controller.branch.BranchService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Double> employeeIds;
        HttpSession session = request.getSession(false);
        String role = (String)session.getAttribute("role");

        ProfileService service = new ProfileService();
        employeeIds = service.getActiveEmployeeIds();
        if(role!=null && role.compareTo("Admin")==0){
            request.setAttribute("employeeIds", employeeIds);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("./profile/DeactivateEmployee.jsp");
        dispatcher.forward(request, response);
    }
}
