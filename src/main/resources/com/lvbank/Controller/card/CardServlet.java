package com.lvbank.Controller.card;

import com.lvbank.model.transaction.Card.Card;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CardServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int masterCardId;
        String cardType;
        Card card = null;
        double accountNumber;
        boolean isCardRegistered;

        accountNumber= Double.parseDouble(request.getParameter("accountNumber"));
        cardType=request.getParameter("cardType");

        CardService service = new CardService();

        if(cardType.compareTo("creditCard")==0){
            masterCardId= Integer.parseInt(request.getParameter("creditMasterId"));
            card = service.getCardInfo(2,masterCardId);
        } else if (cardType.compareTo("debitCard")==0) {
            masterCardId= Integer.parseInt(request.getParameter("debitMasterId"));
            card = service.getCardInfo(1,masterCardId);
        } else if (cardType.compareTo("coBrandedCreditCard")==0) {
            masterCardId= Integer.parseInt(request.getParameter("coCreditMasterId"));
            card = service.getCardInfo(3,masterCardId);
        }

        isCardRegistered = service.registerCard(card,accountNumber);

        PrintWriter out = response.getWriter();
        if(isCardRegistered){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Card Registered.');");
            out.println("</script>");
        }else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Card Registration Failed.');");
            out.println("</script>");
        }

        response.sendRedirect("../Home.jsp");
    }
}
