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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String deviceStatus = request.getParameter("deviceStatus");
        String deviceName = request.getParameter("deviceName");
        String deviceId = request.getParameter("deviceId");

        System.out.println(deviceStatus);
        System.out.println(deviceName);
        System.out.println(deviceId);

        int deviceIdNbr = Integer.parseInt(deviceId);

        Client client = ClientBuilder.newClient();
        String roomId = request.getParameter("roomId");

        WebTarget webTarget = client.target("http://localhost:4141/SmartHouseApi/houseId/").path("rooms").path(roomId).path(deviceId);
        Device dev = new Device();
        dev.setDeviceId(deviceIdNbr);

        int deviceStatusNbr = Integer.parseInt(deviceStatus);

        if (deviceStatusNbr < (130)) {
            dev.setDeviceStatus(255);
        } else {
            dev.setDeviceStatus(0);
        }

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response res = invocationBuilder.put(Entity.entity(dev, MediaType.APPLICATION_JSON));
        
        String roomid = request.getParameter("roomId");

        String roomsURL = "http://localhost:4141/SmartHouseApi/houseId/rooms/";
        WebTarget deviceBaseTarget = client.target(roomsURL).path(roomid);
        String roomContent = deviceBaseTarget.request(MediaType.APPLICATION_JSON).get(String.class);

        Gson gson = new Gson();
        Device[] device = gson.fromJson(roomContent, Device[].class);

        ArrayList<Device> dataList = new ArrayList<Device>();

        dataList.addAll(Arrays.asList(device));

        /*DeviceArrayListBean deviceBean= new DeviceArrayListBean();
        deviceBean.setDevice(dataList);
         */
        HttpSession session = request.getSession();
        session.setAttribute("devicebean", device);

        
        response.sendRedirect(request.getContextPath() + "/main/gui.jsp");
    }
}
