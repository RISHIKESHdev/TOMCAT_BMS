package com.lvbank.Controller.account;

import com.lvbank.model.account.loan.Gold;
import com.lvbank.model.account.loan.Home;
import com.lvbank.model.account.loan.Loan;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddLoanServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double loanAmount,interestRate,accountNumber;
        String loanType;
        Loan loan;
        boolean isLoanRegistered=false;

        loanType=request.getParameter("loanType");
        loanAmount= Double.parseDouble(request.getParameter("loanAmount"));
        interestRate= Double.parseDouble(request.getParameter("interestRate"));
        accountNumber=Double.parseDouble(request.getParameter("accountNumber"));

        AccountService service = new AccountService();

        if(loanType.compareTo("goldLoan")==0){
            String goldPurity;
            double weightInGram,goldValuePerGram;
            goldPurity=request.getParameter("goldPurity");
            weightInGram= Double.parseDouble(request.getParameter("goldWeigh"));
            goldValuePerGram= Double.parseDouble(request.getParameter("goldValue"));

            loan = new Gold(loanAmount,interestRate, Loan.LoanType.valueOf("SECURED"),goldPurity,goldValuePerGram,weightInGram);
            isLoanRegistered= service.registerGoldLoan(loan,accountNumber);
        }else{
            int totalArea,builtUpArea,totalNoOfFloors,totalValue;
            totalArea= Integer.parseInt(request.getParameter("totalArea"));
            builtUpArea= Integer.parseInt(request.getParameter("builtUpArea"));
            totalNoOfFloors= Integer.parseInt(request.getParameter("noOfFloors"));
            totalValue= Integer.parseInt(request.getParameter("totalValue"));

            loan=new Home(loanAmount,interestRate,Loan.LoanType.valueOf("SECURED"),totalArea,builtUpArea,totalNoOfFloors,totalValue);
            isLoanRegistered= service.registerHomeLoan(loan,accountNumber);
        }

        PrintWriter out = response.getWriter();
        if(isLoanRegistered){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Loan Registered.');");
            out.println("</script>");
        }else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Loan Registration Failed.');");
            out.println("</script>");
        }

        response.sendRedirect("../Home.jsp");
    }
}
