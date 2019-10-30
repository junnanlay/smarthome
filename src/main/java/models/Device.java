/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Jun
 */
public class Device {
    private String deviceStatus;
    private String deviceName;
    private String deviceId;


    public Device() {
    }

    public Device(String deviceStatus, String deviceName, String deviceId) {
        this.deviceStatus = deviceStatus;
        this.deviceName = deviceName;
        this.deviceId = deviceId;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "Device{" + "deviceStatus=" + deviceStatus + ", deviceName=" + deviceName + ", deviceId=" + deviceId + '}';
    }
    
    
}
