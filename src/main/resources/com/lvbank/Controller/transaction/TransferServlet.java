package com.lvbank.Controller.transaction;

import com.lvbank.CommonConstant;
import com.lvbank.model.transaction.PaymentMode;
import com.lvbank.model.transaction.TransferTransaction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TransferServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TransferTransaction transferTransaction;
        double accountNumber,transactionAmount,beneficiaryAccountNumber;
        boolean isAmountTransfer;
        String beneficiaryIFSCCode;
        TransferTransaction.TransactionType transactionType;

        TransactionDataLogic dataLogic=new TransactionDataLogic();

        transactionAmount= Double.parseDouble(request.getParameter("transactionAmount"));
        beneficiaryAccountNumber= Double.parseDouble(request.getParameter("beneficiaryAccountNumber"));
        beneficiaryIFSCCode=request.getParameter("beneficiaryIFSCCode");
        transactionType=TransferTransaction.inputTransactionType((request.getParameter("transactionType").compareToIgnoreCase("NEFT")==0)?1:2);
        accountNumber= Double.parseDouble(request.getParameter("accountNumber"));

        transferTransaction = new TransferTransaction(CommonConstant.currentDateTime,transactionAmount,null,beneficiaryAccountNumber,beneficiaryIFSCCode,transactionType);
        isAmountTransfer=dataLogic.insertTransferRecord(transferTransaction,accountNumber);

        PrintWriter out = response.getWriter();
        if(isAmountTransfer){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Amount Transferred.');");
            out.println("</script>");
        }else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Transaction Failed.');");
            out.println("</script>");
        }

        response.sendRedirect("../Home.jsp");
    }
}
