package com.lvbank.Controller.account;

import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AccountIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Double> accountNumbers;
        double customerId;

        customerId= Double.parseDouble(req.getParameter("customerId"));
        AccountService service = new AccountService();

        accountNumbers=service.getAccountNumbers(customerId);
        Gson json = new Gson();
        String customerAccountNumbers = json.toJson(accountNumbers);
        resp.setContentType("text/html");
        resp.getWriter().write(customerAccountNumbers);

        RequestDispatcher dispatcher = req.getRequestDispatcher("./branch/entry/UpdateBranch.jsp");
            dispatcher.forward(req, resp);
    }
}
