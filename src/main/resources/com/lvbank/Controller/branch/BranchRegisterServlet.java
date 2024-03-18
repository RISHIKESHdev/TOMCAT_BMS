package com.lvbank.Controller.branch;

import com.lvbank.CommonConstant;
import com.lvbank.model.bank.Branch;
import com.lvbank.model.navigate.Address;
import com.lvbank.model.navigate.GeoLocation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BranchRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addressLineOne,addressLineTwo,addressLineThree,landMark,city,state,country,pinCode;
        String branchName,bankCode;
        double latitude,longitude;
        long mobileNumber;
        boolean isBranchRegistered=false;

        BranchService service = new BranchService();

        branchName=request.getParameter("branchName");
        bankCode = CommonConstant.BANK_CODE;
        mobileNumber=Long.parseLong(request.getParameter("mobileNumber"));
        latitude=Double.parseDouble(request.getParameter("latitude"));
        longitude=Double.parseDouble(request.getParameter("longitude"));
        addressLineOne=request.getParameter("addressLineOne");
        addressLineTwo=request.getParameter("addressLineTwo");
        addressLineThree=request.getParameter("addressLineThree");
        landMark="Landmark";
        city=request.getParameter("city");
        state=request.getParameter("state");
        country="India";
        pinCode=request.getParameter("pinCode");

        Branch branch = new Branch(branchName,bankCode,mobileNumber);
        Address address = new Address(addressLineOne,addressLineTwo,addressLineThree,landMark,city,state,country,pinCode);
        GeoLocation geoLocation = new GeoLocation(latitude,longitude);
        isBranchRegistered = service.registerBranch(branch,address,geoLocation);

        PrintWriter out = response.getWriter();
        if(isBranchRegistered){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Branch Registered.');");
            out.println("</script>");
        }else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Branch Registration Failed.');");
            out.println("</script>");
        }

        response.sendRedirect("../Home.jsp");
    }
}
