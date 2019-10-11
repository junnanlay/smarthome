/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author Junnan
 */
@Stateless
public class LoginBean {
    
    public LoginBean() {
        
    }
    public File validate(String username, String password) throws FileNotFoundException {
         JsonObject account = Json.createObjectBuilder()
        .add("username", username)
        .add("password", password).build();
        System.out.println(account.toString());
        //TODO tcp koppling;
        File file = new File("C:\\Users\\Jun\\Desktop\\text.json");
        
        return file;
    }

    
}
