package com.lvbank.Controller.profile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DropEmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double employeeId;
        boolean isEmployeeDroped;

        employeeId= Double.parseDouble(request.getParameter("employeeId"));
        ProfileService service = new ProfileService();
        isEmployeeDroped=service.deActivateEmployee(employeeId);

        PrintWriter out = response.getWriter();
        if(isEmployeeDroped){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Employee Dropped.');");
            out.println("</script>");
        }else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Employee Deactivation Failed.');");
            out.println("</script>");
        }

        response.sendRedirect("./Home.jsp");
    }
}
