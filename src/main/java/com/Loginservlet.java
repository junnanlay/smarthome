/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Base64;
import models.Device;
import models.DeviceArrayListBean;
import models.Room;
import models.RoomArrayListBean;


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
        
       System.out.println("hello");         
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
        System.out.println(userURL);
        
        Client client = ClientBuilder.newClient();
        WebTarget userBaseTarget = client.target(userURL);
         
        String userContent = userBaseTarget
        .request(MediaType.APPLICATION_JSON)
        .header("Authorization","Basic "+authStringEnc)
        .get(String.class);
         
        String roomsURL = "http://localhost:4141/SmartHouseApi/houseId/rooms";
        WebTarget deviceBaseTarget= client.target(roomsURL);
        String roomContent = deviceBaseTarget.request(MediaType.APPLICATION_JSON).get(String.class);
        
        Gson gson = new Gson();
        Room[] rooms = gson.fromJson(roomContent, Room[].class); 
        
        ArrayList<Room> dataList = new ArrayList<Room>();
    
        dataList.addAll(Arrays.asList(rooms)); 
        
        /*DeviceArrayListBean deviceBean= new DeviceArrayListBean();
        deviceBean.setDevice(dataList);
        */
        
        RoomArrayListBean roomBean = new RoomArrayListBean();
        roomBean.setRooms(dataList);
        
        HttpSession session = request.getSession();
        session.setAttribute("user", userContent);
        session.setAttribute("roombean", rooms);
        
        for(int i=0; i<dataList.size(); i++) {
            System.out.println(dataList.get(i).getRoomId());
            System.out.println(dataList.get(i).getRoomName());
        }
        client.close();
        response.sendRedirect(request.getContextPath() + "/main/gui.jsp");
    }
    
    public void validate() {
        //TODO login validtion here
    }
    
    public void getDevices() {
        //TODO get rooms here
    }
}
