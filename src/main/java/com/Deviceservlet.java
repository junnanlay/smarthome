/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.Device;
import models.DeviceArrayListBean;

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
        
        Client client = ClientBuilder.newClient();

        String deviceURL = "http://localhost:4141/SmartHouseApi/devices/";
        WebTarget deviceBaseTarget= client.target(deviceURL);
        String deviceContent = deviceBaseTarget.request(MediaType.APPLICATION_JSON).get(String.class);
        
        Gson gson = new Gson();
        Device devices [] = gson.fromJson(deviceContent, Device[].class); 
        
        ArrayList<Device> dataList = new ArrayList<Device>();
    
        dataList.addAll(Arrays.asList(devices)); 
        
        DeviceArrayListBean bean= new DeviceArrayListBean();
        bean.setDevice(dataList);
        
        HttpSession session = request.getSession();
        session.setAttribute("bean", bean);
        
        response.sendRedirect(request.getContextPath() + "/main/gui.jsp");
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String value= request.getParameter("refreshBtn");
        System.out.println("THIS IS NEW VALUEEEEEEEEEEEEEEEEE =  "+value);
        
        if(value!=null){
            Client client = ClientBuilder.newClient();

        String deviceURL = "http://localhost:4141/SmartHouseApi/devices/";
        WebTarget deviceBaseTarget= client.target(deviceURL);
        String deviceContent = deviceBaseTarget.request(MediaType.APPLICATION_JSON).get(String.class);
        
        Gson gson = new Gson();
        Device devices [] = gson.fromJson(deviceContent, Device[].class); 
        
        ArrayList<Device> dataList = new ArrayList<Device>();
    
        dataList.addAll(Arrays.asList(devices)); 
        
        DeviceArrayListBean bean= new DeviceArrayListBean();
        bean.setDevice(dataList);
        
        HttpSession session = request.getSession();
        session.setAttribute("bean", bean);
        
        response.sendRedirect(request.getContextPath() + "/main/gui.jsp");
        }
        
        
        
        
        else{
        
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
        
        
        
        String deviceURL = "http://localhost:4141/SmartHouseApi/devices/";
        WebTarget deviceBaseTarget= client.target(deviceURL);
        String deviceContent = deviceBaseTarget.request(MediaType.APPLICATION_JSON).get(String.class);
        
        Gson gson = new Gson();
        Device devices [] = gson.fromJson(deviceContent, Device[].class); 
        
        ArrayList<Device> dataList = new ArrayList<Device>();
    
        dataList.addAll(Arrays.asList(devices)); 
        
        DeviceArrayListBean bean= new DeviceArrayListBean();
        bean.setDevice(dataList);
        
        HttpSession session = request.getSession();
        session.setAttribute("bean", bean);
        
        response.sendRedirect(request.getContextPath() + "/main/gui.jsp");
        }
    }

}
