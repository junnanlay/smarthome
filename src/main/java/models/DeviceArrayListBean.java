/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author jonny
 */
public class DeviceArrayListBean implements Serializable {
    private ArrayList<Device> device = new ArrayList<Device>();

    public ArrayList<Device> getDevice() {
        return device;
    }

    public void setDevice(ArrayList<Device> device) {
        this.device = device;
    }

    
    public DeviceArrayListBean() {
        
    }
     
}
