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

        Client client = ClientBuilder.newClient();

        String deviceURL = "http://localhost:4141/SmartHouseApi/devices/";
        WebTarget deviceBaseTarget = client.target(deviceURL);
        String deviceContent = deviceBaseTarget.request(MediaType.APPLICATION_JSON).get(String.class);

        Gson gson = new Gson();
        Device devices[] = gson.fromJson(deviceContent, Device[].class);

        ArrayList<Device> dataList = new ArrayList<Device>();

        dataList.addAll(Arrays.asList(devices));

        DeviceArrayListBean bean = new DeviceArrayListBean();
        bean.setDevice(dataList);

        HttpSession session = request.getSession();
        session.setAttribute("bean", bean);

        client.close();
        response.sendRedirect(request.getContextPath() + "/main/gui.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
