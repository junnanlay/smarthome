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
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import models.Device;
import models.DeviceArrayListBean;

/**
 *
 * @author Jun
 */
@WebServlet(name = "Refreshservlet", urlPatterns = {"/Refreshservlet"})
public class Refreshservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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

        String roomid = request.getParameter("roomid");
        Client client = ClientBuilder.newClient();

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
        session.setAttribute("roomid", roomid);
        session.setAttribute("devicebean", device);

        response.sendRedirect(request.getContextPath() + "/main/gui.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
