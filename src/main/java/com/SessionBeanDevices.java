/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.ArrayList;
import javax.ejb.Singleton;
import models.Device;

/**
 *
 * @author jonny
 */
@Singleton
public class SessionBeanDevices {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private ArrayList<Device> arr = new ArrayList<Device>();

    public SessionBeanDevices() {
    }

    public ArrayList<Device> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Device> arr) {
        this.arr = arr;
    }
    
    
}
