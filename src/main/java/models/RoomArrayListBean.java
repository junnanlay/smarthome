/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Jun
 */
public class RoomArrayListBean  implements Serializable{
    private ArrayList<Room> room = new ArrayList<>();

    public RoomArrayListBean() {
    }
    
    
    public ArrayList<Room> getRooms() {
        return room;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.room = rooms;
    }
    
}
