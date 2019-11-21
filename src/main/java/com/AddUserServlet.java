/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.User;

/**
 *
 * @author Jun
 */
@WebServlet(name = "AddUserServlet", urlPatterns = {"/AddUserServlet"})
public class AddUserServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");

        User user = new User(firstname, lastname, email);

        System.out.println(user.toString());

        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:4141/SmartHouseApi/").path("users");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response res = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));

        System.out.println(res.getStatus());

        response.sendRedirect(request.getContextPath() + "/main/settings.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}