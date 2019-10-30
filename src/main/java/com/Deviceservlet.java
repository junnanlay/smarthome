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
import models.Device;

/**
 *
 * @author Jun
 */
@WebServlet(name = "Deviceservlet", urlPatterns = {"/Deviceservlet"})
public class Deviceservlet extends HttpServlet {


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
        
        String deviceBtn = request.getParameter("deviceBtn");
        String deviceStatus = request.getParameter("deviceStatus");
        String deviceName = request.getParameter("deviceName");
        String deviceId= request.getParameter("deviceId");
        
        System.out.println(deviceStatus);
        System.out.println(deviceBtn);
        System.out.println(deviceName);
        System.out.println(deviceId);
        
        int deviceIdNbr = Integer.parseInt(deviceId);
        
        Client client = ClientBuilder.newClient();
        
        WebTarget webTarget = client.target("http://localhost:4141/SmartHouseApi").path("devices").path(deviceId);
        Device dev= new Device();
        dev.setDeviceId(deviceIdNbr);
        
        if(deviceBtn.equals("off")) {
            dev.setDeviceStatus("Off");
        }else {
            dev.setDeviceStatus("On");
        }
        
       
        
        
        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response res = invocationBuilder.put(Entity.entity(dev, MediaType.APPLICATION_JSON));
        
        System.out.println(res.getStatus());
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
