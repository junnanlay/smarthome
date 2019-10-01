/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author Junnan
 */
@Stateless
public class LoginBean {

    public String validate(String username, String password) {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(),12345);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            
            String message = "username = " + username +" password = " + password;
            out.println(message);
        } catch (UnknownHostException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "hello";
    }

    
}
