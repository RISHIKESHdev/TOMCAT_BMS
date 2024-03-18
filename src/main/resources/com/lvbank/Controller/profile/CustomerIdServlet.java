package com.lvbank.Controller.profile;

import com.lvbank.Controller.branch.BranchIdServlet;
import com.lvbank.Controller.branch.BranchService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Double> branchCustomerIds;
        ArrayList<Integer> branchIds;
        HttpSession session = request.getSession(false);
        double employeeId;
        String role = (String)session.getAttribute("role");

        ProfileService service = new ProfileService();

        if(role!=null && role.compareTo("Customer")==0){
            branchCustomerIds=new ArrayList<>();
            branchCustomerIds.add((Double)session.getAttribute("CIFNumber"));
        }else{
            employeeId=(Double)session.getAttribute("employeeId");
            branchCustomerIds=service.getBranchCustomerIds(employeeId);
        }
        branchIds=new BranchService().getActiveBranchListService();
        request.setAttribute("branchCustomerIds", branchCustomerIds);
        session.setAttribute("branchIds", branchIds);

        String requestURL = request.getRequestURL().toString();
        if(requestURL.endsWith("updateBranch")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("./branch/UpdateBranch.jsp");
            dispatcher.forward(request, response);
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("./account/CreateAccount.jsp");
            dispatcher.forward(request, response);
        }
    }
}
