package com.lvbank.Controller.profile.entry;

import com.lvbank.model.navigate.Address;
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

public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName,middleName,lastName,emailId = null,gender,password = null,mobileNumber = null;
        String addressLineOne,addressLineTwo,addressLineThree,landMark,city,state,country,pinCode;
        int age,branchId = 0;
        User user = null;
        Address address;
        boolean isUserSignedUp=false;

        HttpSession session = request.getSession(false);
        EntryService service = new EntryService();

        firstName=request.getParameter("firstName");
        middleName=request.getParameter("middleName");
        lastName=request.getParameter("lastName");
        emailId=request.getParameter("emailId");
        gender=request.getParameter("gender");
        password=request.getParameter("password");
        mobileNumber=request.getParameter("mobileNumber");
        age=Integer.parseInt(request.getParameter("age"));

        addressLineOne=request.getParameter("addressLineOne");
        addressLineTwo=request.getParameter("addressLineTwo");
        addressLineThree=request.getParameter("addressLineThree");
        landMark="Landmark";
        city=request.getParameter("city");
        state=request.getParameter("state");
        country="India";
        pinCode=request.getParameter("pinCode");
        String role=(String)session.getAttribute("role");

        if(role==null){
            String PANNumber,CKYCVerificationDocument,CKYCVerificationId;

            PANNumber=request.getParameter("panNumber");
            CKYCVerificationDocument=request.getParameter("CKYCVerificationDocument");
            CKYCVerificationId=request.getParameter("CKYCVerificationId");

            user = new Customer(firstName,middleName,lastName,emailId,gender,age,mobileNumber,password,PANNumber,CKYCVerificationDocument,CKYCVerificationId);
        }else{
            if(session.getAttribute("branchIds") !=null){
                int yearOfExperience;
                String employeeDesignation;
                double employeeCTC;
                boolean isActive = false;

                employeeCTC=Double.parseDouble(request.getParameter("employeeCTC"));
                employeeDesignation=request.getParameter("employeeDesignation");
                isActive= request.getParameter("isActive").compareToIgnoreCase("Checked")==0;
                yearOfExperience=Integer.parseInt(request.getParameter("yearOfExperience"));
                branchId=Integer.parseInt(request.getParameter("branchId"));

                user = new Employee(firstName,middleName,lastName,emailId,gender,age,mobileNumber,password,employeeDesignation,employeeCTC,yearOfExperience,isActive);

            }else if(role.compareTo("Admin")==0){
                boolean isActive = false;

                isActive=request.getParameter("isActive").compareToIgnoreCase("Checked")==0;

                user = new Admin(firstName,middleName,lastName,emailId,gender,age,mobileNumber,password,isActive);
            }
        }

        if(user!=null){
            address = new Address(addressLineOne,addressLineTwo,addressLineThree,landMark,city,state,country,pinCode);
            user.setAddress(address);
            if(user instanceof Customer){
                isUserSignedUp=service.registerCustomer((Customer) user);
            } else if (user instanceof Employee) {
                isUserSignedUp=service.registerEmployee((Employee) user,branchId);
            } else {
                isUserSignedUp=service.registerAdmin((Admin) user);
            }
        }

        if(!isUserSignedUp){
            if(user instanceof Customer){
                request.setAttribute("errMessage", "Sign Up Failed.");
                request.getRequestDispatcher("./Login.jsp?entryParam=customerLogin").forward(request, response);
            }else{
                request.setAttribute("errMessage", "Sign Up Failed.");
                response.sendRedirect("../../Home.jsp");
            }
        }else{
            if(user instanceof Customer){
                response.sendRedirect("./Login.jsp?entryParam=customerLogin");
            }
            else{
                response.sendRedirect("../../Home.jsp");
            }
        }
    }
}
