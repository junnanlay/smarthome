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
    private int deviceStatus;
    private String deviceName;
    private int deviceId;
    private int roomId;


    public Device() {
    }

    public Device(int deviceStatus, String deviceName, int deviceId) {
        this.deviceStatus = deviceStatus;
        this.deviceName = deviceName;
        this.deviceId = deviceId;
    }

    public int getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(int deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "Device{" + "deviceStatus=" + deviceStatus + ", deviceName=" + deviceName + ", deviceId=" + deviceId + '}';
    }
    
    
}
