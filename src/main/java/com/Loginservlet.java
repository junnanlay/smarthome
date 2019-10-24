/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.User;
import javax.xml.bind.DatatypeConverter;
import java.util.Base64;
//import sun.misc.BASE64Encoder;


/**
 *
 * @author Jun
 */
public class Loginservlet extends HttpServlet {
    
    
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
        String password = request.getParameter("password");
        String userURL = "http://localhost:4141/SmartHouseApi/login/" + email;
        String authString = email + ":" + password;
        String authStringEnc = Base64.getEncoder().encodeToString(authString.getBytes());
        

        //String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
        System.out.println("Base64 encoded auth string: " + authStringEnc);
        
        
        Client client = ClientBuilder.newClient();
        WebTarget userBaseTarget = client.target(userURL);
         
        String userContent = userBaseTarget
        .request(MediaType.APPLICATION_JSON)
        .header("Authorization","Basic "+authStringEnc)
        .get(String.class);
         
        String deviceURL = "http://localhost:4141/SmartHouseApi/devices/";
        WebTarget deviceBaseTarget= client.target(deviceURL);
        String deviceContent = deviceBaseTarget.request(MediaType.APPLICATION_JSON).get(String.class);
        
        HttpSession session = request.getSession();
        session.setAttribute("user", userContent);
        session.setAttribute("devices", deviceContent);
        
        response.sendRedirect(request.getContextPath() + "/main/gui.jsp");
    }
    
    public void validate() {
        //TODO login validtion here
    }
    
    public void getDevices() {
        //TODO get devices here
    }
}
