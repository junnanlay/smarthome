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

/**
 *
 * @author Jun
 */
@WebServlet(name = "Fanservlet", urlPatterns = {"/Fanservlet"})
public class Fanservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String deviceStatus = request.getParameter("deviceStatus");
        String deviceName = request.getParameter("deviceName");
        String deviceId = request.getParameter("deviceId");
        String fanInputName = request.getParameter("fanInputName");
        System.out.println(deviceStatus);
        System.out.println(deviceName);
        System.out.println(deviceId);
        System.out.println(fanInputName);

        int deviceIdNbr = Integer.parseInt(deviceId);
        
        Client client = ClientBuilder.newClient();
        String roomId = request.getParameter("roomId");

        WebTarget webTarget = client.target("http://localhost:4141/SmartHouseApi/").path("rooms").path(roomId).path(deviceId);
        Device dev = new Device();
        dev.setDeviceId(deviceIdNbr);
        
        int fanInputNbr = Integer.parseInt(fanInputName);
        
        dev.setDeviceStatus(fanInputNbr);
        
        System.out.println(dev.toString());
        
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response res = invocationBuilder.put(Entity.entity(dev, MediaType.APPLICATION_JSON));
        
        String roomid = request.getParameter("roomId");

        String roomsURL = "http://localhost:4141/SmartHouseApi/rooms/";
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
