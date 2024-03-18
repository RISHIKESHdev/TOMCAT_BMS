package com.lvbank.Controller.profile.entry;

import com.lvbank.model.profile.Admin;
import com.lvbank.model.profile.Customer;
import com.lvbank.model.profile.Employee;
import com.lvbank.model.profile.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class LoginUserServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        User user = null;
        boolean isUserLoggedIn=false;

        String loginParam = request.getParameter("hdn_loginParam");
        String username = request.getParameter("emailId");
        String password = request.getParameter("password");

        EntryService service = new EntryService();

        if(loginParam.compareTo("customerLogin")==0){
            user=service.getCustomerOnLogin(username,password);
        }else if(loginParam.compareTo("employeeLogin")==0){
            user=service.getEmployeeOnLogin(username,password);
        }else if(loginParam.compareTo("adminLogin")==0){
            user=service.getAdminOnLogin(username,password);
        }

        if(user!=null){
            if(user instanceof Customer){
                ArrayList<Double> customerAccountNumbers = service.getCustomerAccountNumbers(((Customer)user).getCIFNumber());

                HttpSession session = request.getSession();
                session.setAttribute("CIFNumber",((Customer)user).getCIFNumber());
                session.setAttribute("userName",user.getEmailId());
                session.setAttribute("firstName",user.getFirstName());
                session.setAttribute("customerAccountNumbers",customerAccountNumbers);
                session.setAttribute("role","Customer");
                isUserLoggedIn=true;
            } else if (user instanceof Employee) {
                HttpSession session = request.getSession();
                session.setAttribute("isActive",((Employee)user).isActive());
                session.setAttribute("employeeId",((Employee)user).getEmployeeId());
                session.setAttribute("userName",user.getEmailId());
                session.setAttribute("firstName",user.getFirstName());
                session.setAttribute("role","Employee");
                isUserLoggedIn=true;
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("isActive",((Admin)user).isActive());
                session.setAttribute("userName",user.getEmailId());
                session.setAttribute("firstName",user.getFirstName());
                session.setAttribute("role","Admin");
                isUserLoggedIn=true;
            }
        }

        if(!isUserLoggedIn){
            request.setAttribute("errMessage", "Login Failed.");
            request.getRequestDispatcher("./Login.jsp?entryParam="+loginParam).forward(request, response);
        }else{
            response.sendRedirect("../../Home.jsp");
        }
    }
}
