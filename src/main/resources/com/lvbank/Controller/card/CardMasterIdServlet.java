package com.lvbank.Controller.card;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class CardMasterIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Integer> creditCardMasterIds,coBrandCreditCardMasterIds,debitCardMasterIds;

        CardService service = new CardService();

        creditCardMasterIds=service.getCardMasterIds(1);
        coBrandCreditCardMasterIds=service.getCardMasterIds(2);
        debitCardMasterIds=service.getCardMasterIds(3);

        request.setAttribute("creditCardMasterIds", creditCardMasterIds);
        request.setAttribute("coBrandCreditCardMasterIds", coBrandCreditCardMasterIds);
        request.setAttribute("debitCardMasterIds", debitCardMasterIds);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./card/Card.jsp");
        dispatcher.forward(request, response);
    }
}
