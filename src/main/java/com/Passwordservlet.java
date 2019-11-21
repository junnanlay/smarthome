/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
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
@WebServlet(name = "Passwordservlet", urlPatterns = {"/Passwordservlet"})
public class Passwordservlet extends HttpServlet {

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

        String newPassword = request.getParameter("new_password");
        String oldPassword = request.getParameter("old_password");

        String userContent = (String) request.getSession(false).getAttribute("user");

        Gson gson = new Gson();
        User user = gson.fromJson(userContent, User.class);
        String email = user.getEmailAddress();
        System.out.println(user.getEmailAddress());

        System.out.println(newPassword);
        System.out.println(oldPassword);

        String authString = user.getEmailAddress() + ":" + oldPassword;
        String authStringEnc = Base64.getEncoder().encodeToString(authString.getBytes());

        System.out.println(authStringEnc);
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://localhost:4141/SmartHouseApi/").path("login").path(email);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).header("Authorization", "Basic " + authStringEnc);
        Response res = invocationBuilder.put(Entity.entity(newPassword, MediaType.APPLICATION_JSON));

        System.out.println(res.getStatus());
        
        response.sendRedirect(request.getContextPath() + "/main/settings.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
