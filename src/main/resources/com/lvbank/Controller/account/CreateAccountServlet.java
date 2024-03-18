package com.lvbank.Controller.account;

import com.lvbank.CommonConstant;
import com.lvbank.model.account.Account;
import com.lvbank.model.account.CurrentAccount;
import com.lvbank.model.account.FixedDepositAccount;
import com.lvbank.model.account.SavingAccount;
import com.lvbank.model.profile.Nominee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class CreateAccountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isAccountCreated=false;
        int branchId;
        double currentBalance,availableBalance,creditScore,CIFNumber = 0;
        String accountType;
        String firstName,middleName,lastName,emailId,gender,CKYCVerificationDocument,CKYCVerificationId,mobileNumber;
        int age;
        Account account;
        Nominee nominee = null;
        LocalDateTime accountInceptionDateTime;

        currentBalance=Double.parseDouble(request.getParameter("currentBalance"));
        availableBalance=currentBalance;
        creditScore= CommonConstant.INITIAL_CREDIT_SCORE;
        accountInceptionDateTime= CommonConstant.currentDateTime;
        accountType=request.getParameter("accountType");
        branchId=Integer.parseInt(request.getParameter("branchId"));
        CIFNumber=Double.parseDouble(request.getParameter("customerId"));

        firstName=request.getParameter("firstName");
        middleName=request.getParameter("middleName");
        lastName=request.getParameter("lastName");
        emailId=request.getParameter("emailId");
        gender=request.getParameter("gender");
        CKYCVerificationDocument=request.getParameter("CKYCVerificationDocument");
        CKYCVerificationId=request.getParameter("CKYCVerificationId");
        mobileNumber=request.getParameter("mobileNumber");
        age=Integer.parseInt(request.getParameter("age"));

        AccountService service = new AccountService();

        if(accountType.compareTo("Current Account")==0){
            double overDraftLimit;

            overDraftLimit=CommonConstant.INITIAL_OVER_DRAFT_LIMIT;

            account=new CurrentAccount(currentBalance,availableBalance,creditScore,accountInceptionDateTime,overDraftLimit);
        }else if(accountType.compareTo("Saving Account")==0){
            double minimumAccountBalance,withdrawalLimit,rateOfInterest;

            minimumAccountBalance=CommonConstant.MIN_SAVING_ACCOUNT_BALANCE;
            withdrawalLimit=Double.parseDouble(request.getParameter("withdrawalLimit"));
            rateOfInterest=Double.parseDouble(request.getParameter("rateOfInterest"));

            account=new SavingAccount(currentBalance,availableBalance,creditScore,accountInceptionDateTime,minimumAccountBalance,withdrawalLimit,rateOfInterest);
        }else{
            int tenure;
            LocalDateTime matureDateTime;
            double rateOfInterest;

            tenure=Integer.parseInt(request.getParameter("tenure"));
            matureDateTime=CommonConstant.currentDateTime.plusYears(tenure);
            rateOfInterest=Double.parseDouble(request.getParameter("rateOfInterest"));

            account=new FixedDepositAccount(currentBalance,availableBalance,creditScore,accountInceptionDateTime,tenure,matureDateTime,rateOfInterest);
        }
        nominee = new Nominee(firstName,middleName,lastName,emailId,gender,age,mobileNumber,CKYCVerificationDocument,CKYCVerificationId);

        isAccountCreated=service.createAccount(account,branchId,CIFNumber,nominee);

        PrintWriter out = response.getWriter();
        if(isAccountCreated){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Account Registered.');");
            out.println("</script>");
        }else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Account Registration Failed.');");
            out.println("</script>");
        }

        response.sendRedirect("./Home.jsp");
    }
}
