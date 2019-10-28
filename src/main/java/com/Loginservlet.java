/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.google.gson.Gson;
import com.owlike.genson.Genson;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
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
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import jdk.nashorn.internal.parser.JSONParser;
import models.Device;
import models.DeviceArrayListBean;
import scala.util.parsing.json.JSONArray;

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
        
        Gson gson = new Gson();
        Device devices [] = gson.fromJson(deviceContent, Device[].class); 
        
       
        ArrayList<Device> dataList = new ArrayList<Device>();
    
        
        for(Device div : devices) {
                       
           /* System.out.println("DEVICE ID = "+div.getDeviceId());
            System.out.println("DEVICE NAME = "+div.getDeviceName());
            System.out.println("DEVICE STATUS = "+div.getDeviceStatus());*/
            Device device = new Device();
            device.setDeviceId(div.getDeviceId());
            device.setDeviceName(div.getDeviceName());
            device.setDeviceStatus(div.getDeviceStatus());
            dataList.add(device);
            
        }  
        DeviceArrayListBean bean= new DeviceArrayListBean();
        bean.setDevice(dataList);
        session.setAttribute("bean", bean);
        
        
        /*
        SessionBeanDevices session2= new SessionBeanDevices();
        session2.setArr(dataList);
        */
        for(int i=0; i<dataList.size();i++){
            System.out.println("DEVICE ID = "+dataList.get(i).getDeviceId());
            System.out.println("DEVICE NAME = "+dataList.get(i).getDeviceName());
            System.out.println("DEVICE STATUS = "+dataList.get(i).getDeviceStatus());
        }
        
        
       
        
        
        
        
        response.sendRedirect(request.getContextPath() + "/main/gui.jsp");
    }
    
    public void validate() {
        //TODO login validtion here
    }
    
    public void getDevices() {
        //TODO get devices here
    }
}
