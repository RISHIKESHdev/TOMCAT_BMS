package com.lvbank.Controller.branch;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class BranchIdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ArrayList<Integer> activeBranchIdList;
        HttpSession session = request.getSession(false);
        String role=(String)session.getAttribute("role");

        BranchService service = new BranchService();

        if(role!=null && role.compareTo("Admin")==0){
            activeBranchIdList=service.getActiveBranchListService();
            session.setAttribute("branchIds", activeBranchIdList);
            response.sendRedirect("./profile/entry/SignUp.jsp?signUpParam=employeeSignUp");
//            RequestDispatcher dispatcher = request.getRequestDispatcher("./profile/entry/SignUp.jsp?signUpParam=employeeSignUp");
//            dispatcher.forward(request, response);
        }
    }
}
