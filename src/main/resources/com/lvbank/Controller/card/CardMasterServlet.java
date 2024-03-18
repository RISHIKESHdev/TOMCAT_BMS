package com.lvbank.Controller.card;

import com.lvbank.CommonConstant;
import com.lvbank.model.transaction.Card.Card;
import com.lvbank.model.transaction.Card.CoBrandedCreditCard;
import com.lvbank.model.transaction.Card.CreditCard;
import com.lvbank.model.transaction.Card.DebitCard;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class CardMasterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cardName,paymentGateway;
        LocalDateTime inceptionDate;
        boolean isActive=true,isCardMasterInserted=false;
        Card card = null;

        CardService service = new CardService();

        cardName=req.getParameter("cardName");
        inceptionDate= CommonConstant.currentDateTime;
        isActive=true;
        paymentGateway=req.getParameter("cardPaymentGateway");

        if(req.getParameter("cardType").compareTo("debitCard")==0){
            double withdrawalLimit;
            withdrawalLimit=Double.parseDouble(req.getParameter("withdrawalLimit"));

            card = new DebitCard(cardName,inceptionDate,isActive,paymentGateway,withdrawalLimit);
        }else if(req.getParameter("cardType").compareTo("coBrandedCreditCard")==0){
            int interestFreeCreditDays;
            String merchantName;
            double merchantOfferPercentage,rateOfInterest;
            merchantOfferPercentage=Double.parseDouble(req.getParameter("merchantOfferPercentage"));
            rateOfInterest=Double.parseDouble(req.getParameter("rateOfInterest"));
            interestFreeCreditDays=Integer.parseInt(req.getParameter("interestFreeCreditDays"));
            merchantName=req.getParameter("merchantName");

            card = new CoBrandedCreditCard(cardName,inceptionDate,isActive,paymentGateway,interestFreeCreditDays,rateOfInterest,merchantName,merchantOfferPercentage);
        }else if(req.getParameter("cardType").compareTo("creditCard")==0){
            int interestFreeCreditDays;
            double rateOfInterest;
            interestFreeCreditDays=Integer.parseInt(req.getParameter("interestFreeCreditDays"));
            rateOfInterest=Double.parseDouble(req.getParameter("rateOfInterest"));

            card = new CreditCard(cardName,inceptionDate,isActive,paymentGateway,interestFreeCreditDays,rateOfInterest);
        }

        isCardMasterInserted=service.insertNewCardMaster(card);

        if(isCardMasterInserted){
            resp.sendRedirect("../Home.jsp");
        }else{
            req.setAttribute("errMessage", "Sign Up Failed.");
            req.getRequestDispatcher("../Home.jsp").forward(req, resp);
        }
    }
}
